# 📚 인터북 (InterBook)  

## 📌 프로젝트 소개  
**인터북(InterBook)**은 생성형 AI 기술을 활용한 **인터럽티브 E-Book 플랫폼**으로, 사용자의 독서 몰입도를 높이고 사용자 친화적인 독서 환경을 만드는 프로젝트입니다.  
사용자는 다양한 감각적 요소(음악, 이미지, 북마크 )들을 통해 몰입도 높은 독서 경험을 할 수 있으며, AI 기술을 활용해 사용자 맞춤형 콘텐츠를 제공합니다.

</br>

## 📌 프로젝트 목적  
기존 E-Book 서비스에서 부족했던 **몰입감과 상호작용 요소**를 강화하여, 사용자가 책을 '읽는' 경험을 넘어 '체험'할 수 있도록 하는 것이 목표입니다.  
이를 통해 독서 습관을 유독하고, 사용자 중심의 **UI/UX**를 통해 보다 **편리한 독서 환경**을 구축하고자 합니다.  
또한, **AI 이미지 생성 및 음악 삽입 기능**을 통해 독서 콘텐츠의 다양성이 기본이 됩니다. 📖🎵🎨

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
> * Llama 모델을 이용하여 책 데이터 기반으로 문제 생성
### 🌐 사용자 편의 기능  
> * React Router를 통해 SPA 기반의 내비게이션 이동 구현  
> * React Native를 이용하여 어플 사용자 편의성 증가

### 🧰 백업드 API 및 DB 체계화  
> * Spring Boot와 JPA를 활용한 RESTful API 개발  
> * MySQL 기반 ORM 설계를 통해 효율적인 데이터 접근 체계화
> * 쓰레드 풀 도입하여 주요 API에 대한 부하 성능 30% 감소


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
![llama](https://img.shields.io/badge/llama-0078D4?style=for-the-badge&logo=meta&logoColor=white)

![azureopenai](https://img.shields.io/badge/Azure%20OpenAI-0078D4?style=for-the-badge&logo=openai&logoColor=white)


### 🛠 Tools  
![github](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)  



---
### 📱 프로젝트 화면 구성

| 페이지 이름             | 화면 이미지 |
|----------------------|-------------|
| **🏠 메인 페이지**       | <img src="https://github.com/user-attachments/assets/7a1ccae3-05f7-4610-b2da-1358b311a178" alt="메인 페이지" width="380"/> |
| **📖 책 상세 페이지**    | <img src="https://github.com/user-attachments/assets/7a988338-c5e4-40cf-bd47-91be14d32433" alt="책 상세 페이지" width="380"/> |
| **📘 책 읽기 페이지**    | <img src="https://github.com/user-attachments/assets/3edcab0a-5458-4ffb-a36d-3d08a7171b72" alt="책 읽기 페이지" width="380"/> |
| **📘 QnA 페이지**    | <img src="https://github.com/user-attachments/assets/613c37b5-eca3-4900-b4d7-d1d9154f8067" alt="QnA 페이지" width="380" /> |
| **📌 어플 메인 화면** | <img src="https://github.com/user-attachments/assets/3062a2fc-ae93-4eac-b111-5e4147f72daf" alt="읽기 기능 설명" height="600" width="280" style="margin-right: 10px;" /> |
| **📱 어플 상세 화면** |  <img src="https://github.com/user-attachments/assets/a3a666bb-ebf2-42ef-8821-a9090e1e4675" alt="어플 상세" height="600" width="280" style="margin-right: 10px;"/> |
| **📱 어플 읽기 화면** |  <img src="https://github.com/user-attachments/assets/806285c4-cd27-452e-97cd-ec05832ac152" alt="어플 읽기" height="600" width="280"/> |


</br>

## 👋️ 팀원 소개  
| 이름 | 역할 |  
| ---- | ---- |  
| [류명재](https://github.com/xaczxzz) | Frontend,BackEnd|  
| [유범용](https://github.com/qjadyd307) | Frontend |  
| [박기표](https://github.com/ppward) | Frontend(React Native) |  
| [안지성](https://github.com/Ahnjiseong) | AI |
| [유동호](https://github.com/Global-YDH) | AI |

