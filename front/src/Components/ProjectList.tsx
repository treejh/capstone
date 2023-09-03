import { Link } from "react-router-dom";
import { styled } from "styled-components";

export const projects = [
  {
    id: 1,
    crew: 5,
    title: "프로젝트 하실분",
    description: `안녕하세요. 기깔나는 사람들에서 대규모 팀원 모집합니다 🔥 
    우리는 이런 일을 해요!
      
커리어 관리 시대’가 도래함에 따라 ‘나’의 히스토리를 한 곳에 볼 수 있는 온라인 공간이 없다는 걸 알게 되었습니다.



그래서 우리는!! 포트폴리오 + 블로그 + 구인 / 구직 + 사이드 프로젝트 모집 등 한 곳에 작성하고, 공유할 수 있는 서비스를 제작하고 있습니다.



앞으로 다양한 사회 문제를 발견하고 해결할 수 있는 서비스를 만들어 영향력 있는 크루가 되고자 합니다.



우리와 뜻을 함께할 새로운 크루를 모집하오니 많은 관심 부탁드립니다🤗
      `,
    want: `호기심이 많고 성장에 대한 욕구가 가득하신 분!!
    큰 꿈을 향한 새로운 도전에 가슴이 콩닥콩닥 뛰시는 분!!
    팀원을 존중하고 배려하는 따뜻한 마음을 가지신 분!!
    자발적으로 일에서 가치를 찾고 자신의 역할에 동기부여가 되시는 분!!
    `,
    writer: "닉네임",
    finish: 3,
    view: 1,
    comments: 0,
    end: 3,
    tag: ["프론트엔드", "백엔드"],
    stack: ["리액트", "스프링"],
    date: "23.04.08",
  },
  {
    id: 2,
    crew: 5,
    finish: 3,

    title: "사이드 프로젝트 디자이너 구해요",
    writer: "닉네임2",
    view: 2,
    comments: 2,
    end: 4,
    tag: ["프론트엔드", "디자이너"],
    stack: ["자바", "스프링"],
    date: "23.04.08",
  },
  {
    id: 3,
    crew: 5,
    finish: 3,

    title: "프로젝트 하실분3",
    writer: "닉네임3",
    view: 3,
    comments: 3,
    end: 5,
    tag: ["프론트엔드", "안드로이드"],
    stack: ["NodeJS", "스프링"],
    date: "23.04.08",
  },
  {
    id: 4,
    title: "프로젝트 하실분3",
    writer: "닉네임3",
    view: 3,
    comments: 3,
    end: 5,
    crew: 5,
    finish: 3,

    tag: ["프론트엔드", "안드로이드"],
    stack: ["NodeJS", "스프링"],
    date: "23.04.08",
  },
  {
    id: 5,
    title: "프로젝트 하실분3",
    writer: "닉네임3",
    crew: 5,
    finish: 3,

    view: 3,
    comments: 3,
    end: 5,
    tag: ["프론트엔드", "안드로이드"],
    stack: ["NodeJS", "스프링"],
    date: "23.04.08",
  },
  {
    id: 6,
    title: "프로젝트 하실분3",
    writer: "닉네임3",
    view: 3,
    comments: 3,
    crew: 5,
    finish: 3,

    end: 5,
    tag: ["프론트엔드", "안드로이드"],
    date: "23.04.08",

    stack: ["NodeJS", "스프링"],
  },
  {
    id: 7,
    title: "프로젝트 하실분3",
    crew: 5,
    finish: 3,

    writer: "닉네임3",
    view: 3,
    comments: 3,
    end: 5,
    tag: ["프론트엔드", "안드로이드"],
    stack: ["NodeJS", "스프링"],
    date: "23.04.08",
  },
];

const ProjectBox = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  row-gap: 5rem;
  column-gap: 1.875rem;
  margin: 6.25rem 10%;
`;

const Project = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: 18.75rem;
  background-color: whitesmoke;
  border-radius: 3.125rem;
  padding: 1.875rem;
  padding-bottom: 0px;
  color: rgba(0, 0, 0, 0.5);
`;

const Detail = styled.div`
  display: flex;
  width: 100%;
  height: auto;
  justify-content: space-between;
  align-items: center;
`;

const TagBox = styled.div`
  display: flex;
  flex-direction: column;
  &:first-child {
    font-weight: 600;
  }
`;

const Tag = styled.div`
  display: flex;
  margin-top: 0.938rem;
`;

const Range = styled.div`
  width: auto;
  height: auto;
  background-color: #7d92e9;
  padding: 0.438rem 0.5rem;
  font-size: 0.75rem;
  color: white;
  margin-right: 0.938rem;
  border-radius: 1.25rem;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const Stack = styled.div`
  display: flex;
  width: auto;
  align-items: center;
  span {
    margin-right: 0.625rem;
  }
`;

const Title = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: auto;
  height: 7.5rem;
  border-radius: 1.563rem;
  color: black;
  padding: 0.625rem;
  font-weight: 600;
  font-size: 1.563rem;
  text-align: center;
`;

const User = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: 3.125rem;
  border-top: 0.063rem solid;
`;

const UserDetail = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  svg {
    min-width: 1.563rem;
    height: 1.563rem;
    margin-right: 0.625rem;
  }

  span {
    font-size: 0.938rem;
  }
`;

const ProjectDetail = styled.div`
  display: flex;
  justify-content: space-between;

  span {
    margin-right: 0.625rem;
  }
`;

function ProjectList() {
  return (
    <ProjectBox>
      {projects.map((project) => (
        <Link to={`/${project.id}`}>
          <Project key={project.id}>
            <Detail>
              <TagBox>
                <span>마감일 | {project.end}일 남음</span>
                <Tag>
                  <Range>{project.tag[0]}</Range>
                  <Range>{project.tag[1]}</Range>
                </Tag>
              </TagBox>
              <Stack>
                <span>{project.stack[0]}</span>
                <span>{project.stack[1]}</span>
              </Stack>
            </Detail>
            <Title>{project.title}</Title>
            <User>
              <UserDetail>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                  <path d="M399 384.2C376.9 345.8 335.4 320 288 320H224c-47.4 0-88.9 25.8-111 64.2c35.2 39.2 86.2 63.8 143 63.8s107.8-24.7 143-63.8zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256zm256 16a72 72 0 1 0 0-144 72 72 0 1 0 0 144z" />
                </svg>
                <span>{project.writer}</span>
              </UserDetail>
              <ProjectDetail>
                <span>조회 수 {project.view}</span>
                <span>댓글 수 {project.comments}</span>
              </ProjectDetail>
            </User>
          </Project>
        </Link>
      ))}
    </ProjectBox>
  );
}

export default ProjectList;
