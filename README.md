# 📚 인터북 (InterBook)  

## 📌 프로젝트 소개  
**인터북(InterBook)**은 생성형 AI 기술을 활용한 **인터럽티브 E-Book 플랫폼**으로, 사용자의 독서 몰입도를 높이고 사용자 친화적인 독서 환경을 만드는 프로젝트입니다.  
사용자는 다양한 감각적 요소(음악, 이미지, 북링 등)들을 통해 몰입도 높은 독서 경험을 할 수 있으며, AI 기술을 활용해 사용자 맞춤형 콘텐츠를 제공합니다.

</br>

## 📌 프로젝트 목적  
기존 E-Book 서비스에서 부족했던 **몽일감과 상호작용 요소**를 강화하여, 사용자가 책을 '읽는' 경험을 넘어 '체험'할 수 있도록 하는 것이 목표입니다.  
이를 통해 독서 습관을 유독하고, 사용자 중심의 **UI/UX**를 통해 보다 **편리한 독서 환경**을 구축하고자 합니다.  
또한, **AI 이미지 생성 및 음악 삽입 기능**을 통해 독서 콘텐츠의 다양성과 차지성을 기본이 됩니다. 📖🎵🎨

</br>

## 📌 주요 기능  
### 📖 E-Book 리더 기능  
> * 슬라이드 방식의 UI는 React 라이브러리를 통해 구현되었습니다.
### 📖 E-Book 문제 기능
> * 책의 데이터를 가지고 라마 모델을 사용해 이해도 검사

### 🔖 사용자 맞춤 기능  
> * 사용자는 자신이 읽은 페이지를 기준으로 북마크를 저장할 수 있습니다.  
> * 음악 및 이미지를 버튼을 통해 독서 분위기를 자유롭게 설정할 수 있습니다.

### 🧐 생성형 AI 기능  
> * Azure Openai 와 FestAPI를 연동하여 해당 페이지의 글에 맞는 분위기와 음악 생성  

### 🌐 사용자 편의 기능  
> * React Router를 통해 SPA 기반의 내비게이션 이동 구현  
> * React Native를 이용하여 어플 사용자 편의성 증가

### 🧰 백업드 API 및 DB 체계화  
> * Spring Boot와 JPA를 활용한 RESTful API 개발  
> * MySQL 기반 ORM 설계를 통해 효율적인 데이터 접근 체계화
> * 쓰레드 풀 도입하여 주요 API에 대한 부하 성능 30% 감소

</br>

## 🥺 Trouble Shooting  
### ORM 성능 저하 이슈  
> * JOIN이 많은 쿠어리에서 발생한 속도 저하 문제를 `FetchType.LAZY`, JPQL 튜닉을 통해 해결했습니다.  
> * 복지한 연관관계는 DTO 분리를 통해 API 응답 속도 계정  

### 슬라이드 버그  
> * React 슬라이더 컴포넌트의 리렌더링 이슈를 `useMemo`와 `useCallback` 체계화로 해결  
### React Native base64 
> * React Native의 Image 컴포넌트는 uri 형태의 이미지 경로나 require()를 통한 정적 자원 로딩은 지원하지만, base64 문자열을 직접 처리하는 방식은 공식적으로 지원되지 않음
직접 디코딩하여 Blob 형태로 변환하는 방법 고려

</br>

## 📋 ERD Diagram  
![Image](https://github.com/user-attachments/assets/ed089150-29a0-4237-9ae4-79b123e1c964) 
</br>



## 🛠️ 기술 스택
### ⚡️Language & Framework  
![springboot](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)  
![react](https://img.shields.io/badge/react-%2361DAFB.svg?style=for-the-badge&logo=react&logoColor=black)  
![reactnative](https://img.shields.io/badge/reactnative-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)

### 💾 Database  
![mysql](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

### 🧠 AI Model  
![fastapi](https://img.shields.io/badge/fastapi-005571?style=for-the-badge&logo=fastapi&logoColor=white)  
![azureopenai](https://img.shields.io/badge/Azure%20OpenAI-0078D4?style=for-the-badge&logo=openai&logoColor=white)


### 🛠 Tools  
![github](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)  



</br>

## 👋️ 팀원 소개  
| 이름 | 역할 |  
| ---- | ---- |  
| [류명재](https://github.com/xaczxzz) | Frontend,BackEnd|  
| [유범용](https://github.com/qjadyd307) | Frontend |  
| [박기표](https://github.com/ppward) | Frontend(React Native) |  
| [안지성](https://github.com/Ahnjiseong) | AI |
| [유동호](https://github.com/Global-YDH) | AI |

