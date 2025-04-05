package backBook.demo.Service;

import backBook.demo.DTO.*;
import backBook.demo.DAO.Book;
import backBook.demo.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserLikeBookRepository userLikeBookRepository;
    private final UserReadBookRepository userReadBookRepository;
    private final BookTextRepository bookTextRepository;
    private final RecentRepositroy recentRepositroy;
    private final BookMarkRepositroy bookMarkRepositroy;
    private final CompletBookRepository completBookRepository;
    private final RankRepository rankRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    //저장하기 Buillder로 변경해야 됨
    public ResponseEntity<String> addBook(BookDTO bookDTO){
        if(bookRepository.findById(bookDTO.getBookid()).isPresent()){
            return ResponseEntity.badRequest().body("이미 있는 책");
        }

        bookRepository.save(bookDTO);
        return ResponseEntity.ok("저장 완료");
    }
    //전체책 정보 가져오기
    public List<BookDTO> bookFind(){return bookRepository.findAll();}

    //책 업데이트
    public Long bookUpdate(Long id, Book book){
        BookDTO bookDTO = bookRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id를 가진 학생은 없습니다.")
        );
        bookDTO.update(book);
        bookRepository.save(bookDTO);
        return bookDTO.getBookid();
    }
    //책 삭제
    public ResponseEntity<String> deleteBook(Long id){
        Optional<BookDTO> bookDAOOptional = bookRepository.findById(id);

        if(bookDAOOptional.isPresent()){

            bookRepository.deleteById(id);
            return ResponseEntity.ok("해당 책을 삭제 했습니다.");
        }
        else{
            return ResponseEntity.badRequest().body("없는 책 입니다.");
        }
    }
    //책 찾기
    public Optional<BookDTO> bookFindByTitle(String title){
        String trimmedTitle = title.trim();
        return Optional.ofNullable(bookRepository.findByTitle(trimmedTitle)
                .orElseThrow(() -> new IllegalArgumentException("해당 책은 없습니다.")));
    }
    //사용자 id로 저장된 좋아요 책 가져오기
    public List<UserLikeBookDTO> userLikeBook(String id){
        return userLikeBookRepository.findAllByUserId(id);
    }

    //읽은 책 리스트 가져오기
    public List<UserReadBookDTO> userReadBook(String nickname){
        return userReadBookRepository.findAllByNickName(nickname);
    }
    // 해당 id의 책의 모든 글을 가져오는 로직
    public List<BookTextDTO> bookFindText(int id) {
        List<BookTextDTO> result = bookTextRepository.findAllByBookid(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("해당 책은 없습니다.");
        }
        return result;
    }
    //text index을 통해서 삭제하기
    public ResponseEntity<String> bookTextDelete(int id){
        Optional<BookTextDTO> bookTextDAOOptional = bookTextRepository.findByTextIndex(id);
        if(bookTextDAOOptional.isPresent()){
            BookTextDTO bookTextDTO = bookTextDAOOptional.get();
            bookTextRepository.delete(bookTextDTO); // bookTextDAO를 삭제
            return ResponseEntity.ok("해당 책 내용이 삭제되었습니다.");
        }
        else{
            return ResponseEntity.ok("해당 책 내용이 없습니다.");
        }
    }
    // 책 글 저장하기
    public ResponseEntity<String> bookTextSave(BookTextDTO bookTextDTO){
        bookTextRepository.save(bookTextDTO);
        return ResponseEntity.ok("해당 책이 저장 되었습니다.");
    }
    //BookList AI 츨략
    public List<BookDTO> findBookPage(int page) {
        List<BookDTO> findBookAi = new ArrayList<>();
        int pageSize = 4;
        int startIndex = (page - 1) * pageSize;
        int endIndex = startIndex + pageSize;

        for (int i = startIndex; i < endIndex; i++) {
            Optional<BookDTO> bookOptional = bookRepository.findById((long) (i + 1));
            bookOptional.ifPresent(findBookAi::add);
        }

        return findBookAi;
    }
    public Optional<BookDTO.BookDAOMapping> findBookTitle(long bookId) {
        return bookRepository.findByBookid(bookId);
    }
    public Optional<BookDTO> findsBookTitle(int bookId) {
        return bookRepository.findByBookid(bookId);
    }

    public List<BookDTO> findBookAIPage(int page) {
        List<BookDTO> findBookAi = new ArrayList<>();
        int pageSize = 4;
        int startIndex = (page - 1) * pageSize;
        int endIndex = startIndex + pageSize;

        for (int i = startIndex; i < endIndex; i++) {
            Optional<BookDTO> bookOptional = bookRepository.findById((long) (i + 1)); // 데이터베이스의 id는 1부터 시작하는 경우가 많으므로 (i+1)로 설정합니다.
            bookOptional.ifPresent(findBookAi::add);
        }

        return findBookAi;
    }

    public Optional<BookTextDTO.BookMapping> findBookText(int bookid, int page){
        return bookTextRepository.findByBookidAndPage(bookid,page);
    }
    public List<BookDTO> findBookContainTitle(String title){
        List<BookDTO> books = bookRepository.findByTitleContaining(title);

        return books;
    }
    public int findBookContainTitleCount(String title){
        List<BookDTO> books = bookRepository.findByTitleContaining(title);
        return books.size();
    }
    // 테마에 맞는 책 찾기
    public List<BookDTO> findByTheme(String theme){
        List<BookDTO> books = bookRepository.findByThemeContaining(theme);
        return books;
    }
    public List<RecentDTO> findByRecent(String name){
        PageRequest pageRequest = PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "recentIndex"));
        List<RecentDTO> recents = recentRepositroy.findByUserId(name,pageRequest);
        return recents;
    }
    public Page<BookDTO> findBooksWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        return bookRepository.findAll(pageable);
    }
    //최근 본 책 저장
    public void saveRecentBook(RecentDTO recentDTO){
        String userId = recentDTO.getUserId();
        long bookId = recentDTO.getBookId();
        if(recentRepositroy.existsByBookIdAndUserId(bookId,userId)){
            return;
        }
        else{
            recentRepositroy.save(recentDTO);
        }

    }
    public void bookMarkSaveAsync(BookMarkDTO bookMarkDTO, int page, long bookid) {
        executorService.submit(() -> bookMarkSave(bookMarkDTO, page, bookid)); // 비동기 실행
        }
    public void bookMarkSave(BookMarkDTO bookMarkDTO, int page, long bookid) {
        Optional<BookMarkDTO> optionalBookMark = bookMarkRepositroy.findByNicknameAndBookid(bookMarkDTO.getNickname(), bookMarkDTO.getBookid());

        // 책갈피 정보가 존재하면
        optionalBookMark.ifPresentOrElse(
                existingBookMark -> updateBookMark(existingBookMark, bookMarkDTO, page, bookid),
                () -> createNewBookMark(bookMarkDTO)
    );
}

    private void updateBookMark(BookMarkDTO existingBookMark, BookMarkDTO bookMarkDTO, int page, long bookid) {
        // 현재 페이지가 더 크다면 페이지 업데이트
        if (page > existingBookMark.getPage()) {
            existingBookMark.setPage(bookMarkDTO.getPage());

            bookMarkRepositroy.save(existingBookMark);  // 책갈피 정보 업데이트
        }

        // 책을 완독했으면, 완료 처리
        if (page >= bookMarkDTO.getPage()) {
            handleCompleteBook(bookMarkDTO, bookid);
        }
    }
    // builder 패턴 사용시 과부화 발생 ( TPS 516, MTT 8.77 ,
//    private void updateBookMark(BookMarkDAO existingBookMark, BookMarkDAO bookMarkDAO, int page, long bookid) {
//        // 현재 페이지가 더 크다면 새 객체 생성 및 업데이트
//        if (page > existingBookMark.getPage()) {
//            BookMarkDAO updatedBookMark = BookMarkDAO.builder()
//                    .id(existingBookMark.getId()) // 기존 객체의 ID를 유지
//                    .nickname(existingBookMark.getNickname())
//                    .bookid(existingBookMark.getBookid())
//                    .page(page) // 새 페이지로 업데이트
//                    .build();
//            bookMarkRepositroy.save(updatedBookMark);
//        }
//
//        // 책을 완독했으면, 완료 처리
//        if (page >= bookMarkDAO.getPage()) {
//            handleCompleteBook(bookMarkDAO, bookid);
//        }
//    }

    private void createNewBookMark(BookMarkDTO bookMarkDTO) {
        BookMarkDTO newBookMark = BookMarkDTO.builder()
                .nickname(bookMarkDTO.getNickname())
                .bookid(bookMarkDTO.getBookid())
                .page(bookMarkDTO.getPage())
                .build();
        bookMarkRepositroy.save(newBookMark);  // 새로운 책갈피 정보 저장
    }

    private void handleCompleteBook(BookMarkDTO bookMarkDTO, long bookid) {
        boolean isCompleted = completBookRepository.existsByNicknameAndBookid(bookMarkDTO.getNickname(), bookMarkDTO.getBookid());
        if (!isCompleted) {
            CompletBookDTO newCompletBook = CompletBookDTO.builder()
                    .nickname(bookMarkDTO.getNickname())
                    .bookid(bookid)
                    .build();
            completBookRepository.save(newCompletBook);
            System.out.println("책이 완료되었습니다.");
        } else {
            System.out.println("이미 완료된 책입니다.");
        }
    }

    public Optional<Integer> getPage(String nickname, Long bookid) {
        return bookMarkRepositroy.findPageByNicknameAndBookid(nickname, bookid);
    }
//    책의 조회수를 기록
//    public String getViewCnt(int bookid, String thema, String title){
//
//    }
    // 해당 책이 조회수 db에 저장되어 있지 않으면 그 데이터를 저장하는 코드
    public String saveViewBook(RankBookDTO rankBookDTO){
        if (rankBookDTO.getBookid() == null) {
            throw new IllegalArgumentException("Book ID must not be null");
        }
        Optional<RankBookDTO> optionalRankBookDAO = rankRepository.findById(rankBookDTO.getBookid());
        System.out.println(optionalRankBookDAO+"조회수 데이터 확인 하는 코드");
            if(optionalRankBookDAO.isPresent()){
                return "0";
            }
            else{
                rankRepository.save(rankBookDTO);
                return "200";
            }
    }

    //테마 가지고 랜덤으로 책 3개 가져오
    public List<BookDTO> getRandomBooksByThemes(String[] themes) {
        // JPA에서 입력받은 테마들로 책을 가져오기
        List<BookDTO> books = bookRepository.findByThemeAndBookIdRange(List.of(themes));

        // 가져온 책 리스트를 랜덤으로 섞기
        Collections.shuffle(books);

        // 3개의 책만 반환 (책이 3개 미만이면 전체 반환)
        return books.size() > 3 ? books.subList(0, 3) : books;
    }
    //책 의 글 다 가져와서 질문으로 보내기
//    public Optional<String> getQnAString(int id){
//        findBookText(id)
//    }


}
