import { Link } from "react-router-dom";
import { styled } from "styled-components";
import Header from "../Components/Header";

const Wrapper = styled.div`
  padding: 50px 200px 150px 300px;
`;

const Title = styled.div`
  margin-top: 50px;
  display: flex;
  align-items: center;
  border-bottom: 2px solid rgba(0, 0, 0, 0.1);
  padding-bottom: 30px;
  div {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 25px;
    font-weight: 600;
    width: 40px;
    height: 40px;
    border-radius: 20px;
    margin-right: 20px;
    background-color: #7d92e9;
    color: white;
  }
  h1 {
    font-size: 25px;
    font-weight: 600;
  }
`;

const Info = styled.div`
  margin-top: 50px;
  padding: 0px 100px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(2, 1fr);
  grid-row-gap: 50px;
  margin-bottom: 100px;
`;
const InfoSelect = styled.div`
  h1 {
    font-size: 25px;
    font-weight: 600;
    margin-bottom: 20px;
  }
  select {
    width: 50%;
    padding: 10px 15px;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border: 1px solid #999;
    background: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxkwxLjLLTs9GYubvxA-r8Bd3XoIcKLi9RpQ&usqp=CAU");
  }

  input {
    width: 50%;
    padding: 10px 15px;
    border: 1px solid #999;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
  }
`;

const Description = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  margin-top: 100px;
  margin-bottom: 100px;
  input {
    padding: 10px 10px;
  }
  input:focus {
    outline: none;
  }
  input::placeholder {
    color: black;
    opacity: 1;
  }
  input:first-child {
    margin-bottom: 20px;
    height: 40px;
  }
  input:last-child {
    height: 300px;
  }
`;

const BtnDiv = styled.div`
  display: flex;
  justify-content: end;
  margin-right: 50px;

  button {
    margin-right: 20px;
    background-color: teal;
    border-radius: 15px;
    border: 0;
    color: white;
    font-weight: 600;
    padding: 5px 20px;
  }
  input {
    background-color: #7d92e9;
    border-radius: 20px;
    border: 0;
    color: white;
    padding: 5px 20px;
    font-weight: 600;
  }
`;

function CreateProject() {
  return (
    <>
      <Header />
      <Wrapper>
        <Title>
          <div>1</div>
          <h1>프로젝트 기본정보</h1>
        </Title>
        <Info>
          <InfoSelect>
            <h1>모집 인원</h1>
            <select>
              <option>미정</option>
              <option>1명</option>
              <option>2명</option>
              <option>3명</option>
              <option>4명</option>
              <option>5명</option>
            </select>
          </InfoSelect>
          <InfoSelect>
            <h1>모집 마감일</h1>
            <input type="date" placeholder="날짜 선택"></input>
          </InfoSelect>
          <InfoSelect>
            <h1>모집 분야</h1>
            <select>
              <option>프론트엔드</option>
              <option>백엔드</option>
              <option>디자이너</option>
              <option>안드로이드</option>
            </select>
          </InfoSelect>
          <InfoSelect>
            <h1>예상기간</h1>
            <select>
              <option>미정</option>
              <option>1개월~3개월</option>
              <option>3개월~6개월</option>
              <option>6개월~1년</option>
              <option>1년 이상</option>
            </select>
          </InfoSelect>
          <InfoSelect>
            <h1>사용 스택</h1>
            <select>
              <option>React</option>
              <option>NodeJS</option>
              <option>NextJs</option>
              <option>NestJs</option>
              <option>Python</option>
              <option>Spring</option>
              <option>TypeScript</option>
              <option>JavaScript</option>
              <option>Vue</option>
              <option>Java</option>
              <option>C</option>
              <option>Go</option>
              <option>Swift</option>
              <option>Kotlin</option>
              <option>MySQL</option>
              <option>MongoDB</option>
              <option>php</option>
              <option>GraphQL</option>
              <option>Firebase</option>
              <option>Unity</option>
              <option>Flutter</option>
              <option>AWS</option>
              <option>Docker</option>
              <option>Git</option>
              <option>Figma</option>
              <option>Zeplin</option>
            </select>
          </InfoSelect>
          <InfoSelect>
            <h1>연락 방법</h1>
            <select>
              <option>1대1 채팅</option>
              <option>카카오톡 오픈채팅</option>
            </select>
          </InfoSelect>
        </Info>
        <Title>
          <div>2</div>
          <h1>프로젝트 소개</h1>
        </Title>
        <Description>
          <input type="text" placeholder="제목을 입력해주세요" />
          <input type="text" placeholder="프로젝트를 소개해주세요" />
        </Description>
        <Title>
          <div>3</div>
          <h1>이런 파트너를 찾아요</h1>
        </Title>
        <input
          style={{
            width: "100%",
            height: "300px",
            marginTop: "100px",
            marginBottom: "100px",
            padding: "10px 10px",
          }}
          type="text"
          placeholder="희망하는 파트너에 대해 자세히 설명해주세요"
        />
        <BtnDiv>
          <Link to={"/"}>
            <button>취소</button>
          </Link>
          <input type="submit" value="글 등록" />
        </BtnDiv>
      </Wrapper>
    </>
  );
}
export default CreateProject;
