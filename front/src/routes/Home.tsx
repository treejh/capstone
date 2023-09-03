import styled from "styled-components";
import Header from "../Components/Header";
import Footer from "../Components/Footer";
import ProjectList from "../Components/ProjectList";
import { useEffect, useState } from "react";

interface parts {
  name: string;
  stack: [string];
}

const parts = [
  { name: "프론트엔드", stack: ["React", "JavaScript", "Vue", "Python"] },
  { name: "백엔드", stack: ["Spring", "NodeJS", "Django", "Go"] },
  { name: "디자이너", stack: ["Figma", "그림판", "PhotoShop"] },
  {
    name: "모바일",
    stack: ["Kotlin", "Java", "Swift", "Flutter", "ReactNative"],
  },
];

const Notice = styled.div`
  width: auto;
  height: 21.875rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  background-color: #fff088;
  margin: 1.875rem 18.75rem 1.875rem 18.75rem;
  display: flex;

  border-radius: 1.25rem;
  font-size: 3.125rem;
  font-weight: 800;
  color: ${(props) => props.theme.textColor};
`;

const DotBox = styled.div`
  display: flex;
  width: 100%;
  margin-top: 0.625rem;
  align-items: center;
  justify-content: center;
`;

const Dot = styled.div`
  width: 0.625rem;
  height: 0.625rem;
  border-radius: 50%;
  background-color: gray;
`;

const Filter = styled.div`
  width: auto;
  height: 21.875rem;
  background-color: #7d92e9;
  margin: 1.875rem 18.75rem 1.875rem 18.75rem;
  display: flex;
  flex-direction: column;
  align-items: start;
  border-radius: 1.25rem;
  padding: 1.25rem 1.25rem;
  font-weight: 600;
  color: ${(props) => props.theme.bgColor};
`;

const Part = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  span {
    font-size: 1.438rem;
    padding: 0px 0.625rem;
    border-right: 0.125rem solid white;
    margin-right: 0.625rem;
    cursor: pointer;

    &:last-child {
      border: none;
    }
    &:hover {
      text-decoration: underline;
    }
  }
`;

const Stack = styled.div`
  display: flex;
  font-size: 25px;
  margin-top: 50px;
  li {
    list-style: none;
    margin-right: 20px;
    cursor: pointer;
    &:hover {
      text-decoration: underline;
    }
  }
`;

const Select = styled.div`
  display: flex;
  font-size: 15px;
  margin-top: 100px;
  li {
    display: flex;
    align-items: center;
    list-style: none;
    margin-right: 20px;
    background-color: whitesmoke;
    padding: 5px 10px;
    color: black;
    border-radius: 30px;
    cursor: pointer;
    svg {
      margin-left: 5px;
    }
  }
`;

function Home() {
  const [part, setPart] = useState("프론트엔드");
  const [stack, setStack] = useState<any[]>([]);
  const [select, setSelect] = useState<any[]>([]);

  const partClick = (event) => {
    setPart(event.target.innerText);
  };
  const selectClick = (event) => {
    setSelect((select) => [...select, event.target.innerText]);
  };
  const deleteClick = (event) => {
    const index = select.indexOf(event.target.innerText);
    select.splice(index, 1);
    console.log(select);
  };
  useEffect(() => {
    switch (part) {
      case "프론트엔드":
        setStack(parts[0].stack);
        break;
      case "백엔드":
        setStack(parts[1].stack);
        break;
      case "디자이너":
        setStack(parts[2].stack);
        break;
      case "모바일":
        setStack(parts[3].stack);
        break;
    }
  }, [part]);

  return (
    <>
      <Header />
      <Notice>
        <p>공 지 사 항</p>
        <p>
          디자인 갈아엎기(+반응형), 페이징처리, 프로젝트 수정 페이지,정렬
          컴포넌트
        </p>
      </Notice>
      <DotBox>
        <Dot />
      </DotBox>
      <Filter>
        <Part>
          <span onClick={partClick}>프론트엔드</span>
          <span onClick={partClick}>백엔드</span>
          <span onClick={partClick}>디자이너</span>
          <span onClick={partClick}>모바일</span>
        </Part>
        <Stack>
          {stack.map((stack) => (
            <li onClick={selectClick}>{stack}</li>
          ))}
        </Stack>
        <Select>
          {select.map((select) => (
            <li key={select.id} onClick={deleteClick}>
              {select}
              <svg
                xmlns="http://www.w3.org/2000/svg"
                height="1em"
                viewBox="0 0 384 512"
              >
                <path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z" />
              </svg>
            </li>
          ))}
        </Select>
      </Filter>

      <ProjectList />
      <Footer></Footer>
    </>
  );
}

export default Home;
