package backBook.demo.Controller;

import backBook.demo.DTO.*;
import backBook.demo.DAO.Book;
import backBook.demo.Service.BookService;
import backBook.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;
    private final UserService userService;
    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    ///책 저장
    @PostMapping("/post/book")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.ok().build(); // 저장 성공을 나타내는 응답 반환
    }
    @GetMapping("/book/all")
    public List<BookDTO> bookFindAll(){

        System.out.println("dsad");
        return bookService.bookFind();

    }
    //기본책 가져오기
    @GetMapping("/book/find/{page}")
    public List<BookDTO> bookFindPage(@PathVariable int page){
        return bookService.findBookPage(page);

    }
    //Ai 책 가져오기
    @GetMapping("/book/findAi/{page}")
    public List<BookDTO> bookFindAiPage(@PathVariable int page){
        return bookService.findBookAIPage(page);

    }
    //수정하기
    @PostMapping("/post/{id}")
    public ResponseEntity<String> bookUpdate(@PathVariable Long id , @RequestBody Book book){
        long updateBookId = bookService.bookUpdate(id,book);
        return ResponseEntity.ok("Book Update");
    }
    //책 제목으로 찾기
    @GetMapping("/book/{title}")
    public Optional bookFindTitle(@PathVariable String title){
        return bookService.bookFindByTitle(title);
    }

    // id로 책 삭제 하기
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
//    @GetMapping("/find/{id}")
//
////    //사용자 좋아하는 책 리스트
////    public ResponseEntity<String> findBookUser(@PathVariable String id){
////
////    }
//    @GetMapping("/test/{id}")
//    public List<UserLikeBookDAO> findBookuser(@PathVariable Long id){
//        return bookService.userLikeBook(id);
//
//    }
    @GetMapping(value = "/user/book/{nickname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserReadBookDTO> findReadBookUser(@PathVariable String nickname){
//      return bookService.userReadBook(nickname);
        List <UserReadBookDTO> user = bookService.userReadBook(nickname);
        if(user.isEmpty()){

            return null;
        }
        else{
            return user;
        }
    }
    //id를 통한 해당 책의 글을 가져옴
    @GetMapping("/book/text/{id}")
    public List<BookTextDTO> bookFindAllText(@PathVariable int id){
        return bookService.bookFindText(id);
    }
    //id를 통한 해당 책 삭제
    @DeleteMapping("/book/text/delete/{id}")
    public void deleteBookText(@PathVariable int id){
        bookService.bookTextDelete(id);
    }
    //책 내용 저장
    @PostMapping("/book/text/save")
    public void saveBookText(@RequestBody BookTextDTO bookTextDTO){
        bookService.bookTextSave(bookTextDTO);
    }
    //해당 책 의 글 출력하기
    @GetMapping("/book/text/{id}/{page}")
    public Optional<BookTextDTO.BookMapping> loadBookText(@PathVariable int id, @PathVariable int page){
        return bookService.findBookText(id,page);
    }
    // 책의 제목을 통해 포함된 제목 가져오기
    @GetMapping("/book/contain/{title}")
    public List<BookDTO> getByTitleList(@PathVariable String title){
        return bookService.findBookContainTitle(title);
    }
    @GetMapping("/book/contain/count/{title}")
    public int getByTitleListCount(@PathVariable String title){
        return bookService.findBookContainTitleCount(title);
    }
    //테마에 맞는 책 불러오기
    @GetMapping("/book/theme/{theme}")
    public List<BookDTO> getByThemeList(@PathVariable String theme) throws UnsupportedEncodingException {
//        String encodedTheme = URLEncoder.encode(theme, "UTF-8");
//        System.out.println(encodedTheme);
        return bookService.findByTheme(theme);
    }
    // 읽은 책 저장 하기 nickName, bookId 이런식으로 저장 해야됨
    @GetMapping("/book/readBookUser")
    public void addReadBookUser(@RequestBody UserReadBookDTO userReadBookDTO) {

        userService.AddUserRead(userReadBookDTO);

    }
    //책 아이디로 책 제목 가져옴
    @GetMapping("/book/title/{bookid}")
    public Optional<BookDTO.BookDAOMapping> findBookTitlebyBookId(@PathVariable int bookid){
        return bookService.findBookTitle(bookid);
    }
    @GetMapping("/books/title/{bookid}")
    public Optional<BookDTO> findsBookTitlebyBookId(@PathVariable int bookid){
        return bookService.findsBookTitle(bookid);
    }
    // 유저 id로 좋아요한 책 가져오기
    @GetMapping("/book/{userId}/findLike")
    public List<UserLikeBookDTO> getListLikeBook(@PathVariable String userId){
        return bookService.userLikeBook(userId);
    }
//    최근에 본 책 저장 하기
    @PostMapping("/book/save/recent")
    public String saveRecentBook(@RequestBody RecentDTO recentDTO, RankBookDTO rankBookDTO){
        bookService.saveRecentBook(recentDTO);
//        bookService.saveViewBook(rankBookDAO);
        return "200";
    }
//    유저 아이디로 최근 책 가져오기
    @GetMapping("/book/recent/{userId}")
    public List<RecentDTO> findRecentBook(@PathVariable String userId){
        return bookService.findByRecent(userId);

    }
    @PostMapping("/book/bookmark/{page}/{bookid}")
    public ResponseEntity<String> saveBookMark(
            @RequestBody BookMarkDTO bookMarkDTO,
            @PathVariable int page,
            @PathVariable long bookid) {
        // 비동기 방식으로 책갈피 저장 작업 처리
        bookService.bookMarkSaveAsync(bookMarkDTO, page, bookid);
        System.out.println("비동기 책갈피 기능 처리 중");
        return ResponseEntity.ok("요청이 처리되었습니다.");
    }

    //책갈피 페이지수 가져오는 것
    @GetMapping("/book/bookmark/page/{nickname}/{bookid}")
    public ResponseEntity<Integer> getPage(@PathVariable String nickname, @PathVariable Long bookid) {
        Optional<Integer> page = bookService.getPage(nickname, bookid);
        return page.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/book/random/thema")
    public List<BookDTO> randomBooks(@RequestBody String [] userThema){
        System.out.println("호출 됨");
        return bookService.getRandomBooksByThemes(userThema);

    }
    @GetMapping("/test/{page}/{size}")
    public ResponseEntity<Page<BookDTO>> getBooks(
            @RequestParam(defaultValue = "0") int page, // 기본값: 0
            @RequestParam(defaultValue = "10") int size // 기본값: 10
    ) {
        Page<BookDTO> books = bookService.findBooksWithPagination(page, size);
        return ResponseEntity.ok(books);
    }








}
