import { styled } from "styled-components";
import { Link } from "react-router-dom";

const Wrapper = styled.div`
  width: 100vw;
  height: 100vh;
  padding: 50px 200px 00px 200px;
  background-color: whitesmoke;
  svg {
    width: 30px;
    height: 30px;
    margin-bottom: 30px;
  }
`;

const ChatBox = styled.div`
  display: flex;
  justify-content: space-around;
  width: 100%;
  height: auto;
`;

const Chatting = styled.div`
  width: 30%;
  height: 700px;
  background-color: #b1c7d9;
  border-radius: 50px;
  position: relative;

  input {
    width: 100%;
    height: 120px;
    border-radius: 3px;
    border: 0;
    position: absolute;
    bottom: -5px;
    line-height: 5px;
  }

  button {
    font-size: 12px;
    font-weight: 600;
    background-color: #feff86;
    border: 0;
    width: 10%;
    border-radius: 5px;
    height: 30px;
    position: absolute;
    right: 10px;
    bottom: 5px;
    float: right;
  }
`;
const ChatList = styled.div`
  width: 50%;
  height: 700px;
  border-radius: 60px;
  background-color: teal;
  border: 5px solid white;
`;

function Chat() {
  return (
    <>
      <Wrapper>
        <Link to={"/"}>
          <span>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
              <path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z" />
            </svg>
          </span>
        </Link>
        <ChatBox>
          <Chatting>
            <form>
              <input></input>
              <button>전송</button>
            </form>
          </Chatting>
          <ChatList></ChatList>
        </ChatBox>
      </Wrapper>
    </>
  );
}
export default Chat;
