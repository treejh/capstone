import { styled } from "styled-components";
import Header from "../Components/Header";
import { Link } from "react-router-dom";
import axios from "axios";
import { error } from "console";

const users = {
  id: 1,
  github: "abcd123",
  name: "홍길동",
  password: 1234,
  produce: "안녕하세요",
  stacks: ["Java", "React"],
  hopePro: ["육아 다이어리", "프로젝트 매칭"],
  image: "프로필사진",
};

const Wrapper = styled.div`
  width: 100vw;
  height: 100vh;
  padding: 100px;
  display: flex;
  background-color: whitesmoke;
`;

const ProfileBox = styled.div`
  width: 700px;
  height: 500px;
  border: none;
  border-radius: 30px;
  box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-size: 1.2rem;
  background-color: white;
  span {
    margin-bottom: 30px;
  }
`;

const Chat = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.2rem;
  font-weight: 600;
  border-radius: 10px;
  background-color: #fee500;
  padding: 10px 20px;
  color: black;
  margin-right: 20px;
  svg {
    margin-right: 5px;
  }
`;
const EditProfile = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.2rem;
  font-weight: 600;
  border-radius: 10px;
  background-color: whitesmoke;
  padding: 10px 20px;
  color: black;
  svg {
    margin-right: 5px;
  }
`;

const Subbox = styled.div`
  display: flex;
  height: 50%;
  flex-direction: column;
  justify-content: start;
  align-items: center;
  font-weight: 600;
  p {
    margin: 18px 0px;
  }
`;
const ProduceBox = styled.div`
  width: 80%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 10px;
  height: auto;
  padding: 20px;
  border-top: 2px solid gray;
  font-weight: 600;
  p:first-child {
    margin-bottom: 20px;
    opacity: 0.5;
  }
`;

const EtcBox = styled.div`
  width: 60%;
  height: 100%;
  background-color: white;
  border-radius: 30px;
  border: 3px solid white;
  margin-left: 30px;
  display: flex;
  flex-direction: column;
  padding: 10px;
`;

const TopDiv = styled.div`
  width: 100%;
  height: 50%;
  border-bottom: 2px solid black;
  display: flex;
  padding: 20px;
`;

const StackBox = styled.div`
  border-right: 2px solid black;
  width: 50%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: start;
  span {
    margin-bottom: 30px;
    &:first-child {
      font-size: 1.6rem;
    }
  }
  ul {
    width: 50%;
    display: flex;
    justify-content: space-around;
  }
  ul > span {
    background-color: #7d92e9;
    padding: 3px 20px;
    font-size: 1.6rem;
    border-radius: 30px;
    appearance: none;
    color: black;
  }
  align-items: center;
  font-weight: 600;
`;

const HopePro = styled.div`
  font-weight: 600;
  padding-left: 30px;
  width: 50%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: start;
  span {
    &:first-child {
      font-size: 1.6rem;
      margin-bottom: 20px;
    }
  }
  ul {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  ul > span {
    padding: 3px 12px;
    font-size: 15px;
    border-radius: 15px;
  }
  align-items: center;
`;
const CircleStyle = styled.div`
  width: 15px;
  height: 15px;
  border-radius: 7.5px;
  background-color: yellowgreen;
  margin-right: 10px;
`;

const CircleBox = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 20px;
`;

function Profile() {
  axios
    .get("/api/v1/users/${username}")
    .then((res) => {
      console.log(res);
    })
    .catch((error) => {
      console.log(error);
    });
  return (
    <>
      <Header />
      <Wrapper>
        <ProfileBox>
          <Subbox>
            <span>{users.image}</span>
            <p>{users.name}</p>
            <p style={{ marginBottom: "50px" }}>{users.github}</p>
            <div style={{ display: "flex" }}>
              <Link to={"/chat"}>
                <Chat>
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    height="1em"
                    viewBox="0 0 512 512"
                  >
                    <path d="M512 240c0 114.9-114.6 208-256 208c-37.1 0-72.3-6.4-104.1-17.9c-11.9 8.7-31.3 20.6-54.3 30.6C73.6 471.1 44.7 480 16 480c-6.5 0-12.3-3.9-14.8-9.9c-2.5-6-1.1-12.8 3.4-17.4l0 0 0 0 0 0 0 0 .3-.3c.3-.3 .7-.7 1.3-1.4c1.1-1.2 2.8-3.1 4.9-5.7c4.1-5 9.6-12.4 15.2-21.6c10-16.6 19.5-38.4 21.4-62.9C17.7 326.8 0 285.1 0 240C0 125.1 114.6 32 256 32s256 93.1 256 208z" />
                  </svg>
                  1대1 채팅
                </Chat>
              </Link>
              <EditProfile>프로필 수정</EditProfile>
            </div>
          </Subbox>
          <ProduceBox>
            <p>자기소개</p>
            <p>{users.produce}</p>
          </ProduceBox>
        </ProfileBox>
        <EtcBox>
          <TopDiv>
            <StackBox>
              <span>선호하는 기술</span>
              <ul>
                {users.stacks.map((stack) => (
                  <span>{stack}</span>
                ))}
              </ul>
            </StackBox>
            <HopePro>
              <span>프로젝트 목록</span>
              <ul>
                {users.hopePro.map((hope) => (
                  <CircleBox>
                    <CircleStyle></CircleStyle>
                    <span>{hope}</span>
                  </CircleBox>
                ))}
              </ul>
            </HopePro>
          </TopDiv>
          <div
            style={{
              padding: "20px",
              fontWeight: "600",
              fontSize: "1.7rem",
            }}
          >
            Github Contribution
          </div>
        </EtcBox>
      </Wrapper>
    </>
  );
}
export default Profile;
