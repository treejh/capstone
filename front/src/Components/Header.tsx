import { styled } from "styled-components";
import { Link } from "react-router-dom";

const Nav = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  width: 100%;
  margin-bottom: 0.25rem;

  padding: 1.875rem 5%;
  font-size: 1.25rem;
  font-weight: 600;
  color: ${(props) => props.theme.textColor};
  box-shadow: 0px 0.125rem 0.25rem rgba(0, 0, 0, 0.2);
  span {
    margin-right: 21.875rem;
  }
`;

const SearchForm = styled.form`
  display: flex;
  width: 30%;
  height: 2.5rem;
  padding: 0px 2%;
  border: 0.125rem solid rgba(0, 0, 0, 0.3);
  outline: none;
  border-radius: 3.125rem;
  align-items: center;
`;
const SearchInput = styled.input`
  width: 100%;
  height: 100%;
  outline: none;
  border: none;
  &::placeholder {
    font-size: 0.75rem;
    color: black;
    opacity: 0.5;
    font-weight: 600;
  }
`;
const SearchBtn = styled.button`
  border: none;
  outline: none;
  background-color: white;
  font-size: 1rem;
  opacity: 0.5;
  cursor: pointer;
`;

const NavRoute = styled.nav`
  display: flex;
  justify-content: end;
  align-items: center;
  width: 25%;
  opacity: 0.6;
  span {
    margin-right: 1.563rem;
  }
`;

const user = {
  logIn: false,
};

function Header() {
  return (
    <Nav>
      <Link to={"/"}>
        <span>로고</span>
      </Link>

      <SearchForm>
        <SearchInput type="text" placeholder="검색"></SearchInput>
        <SearchBtn type="submit">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            height="1em"
            viewBox="0 0 512 512"
          >
            <path d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z" />
          </svg>
        </SearchBtn>
      </SearchForm>

      {user.logIn === true ? (
        <NavRoute>
          <Link to={"/chat"}>
            <span>채팅</span>
          </Link>
          <Link to={"/createproject"}>
            <span>프로젝트 생성</span>
          </Link>
          <span style={{ cursor: "pointer" }}>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              height="1em"
              viewBox="0 0 448 512"
            >
              <path d="M224 0c-17.7 0-32 14.3-32 32V51.2C119 66 64 130.6 64 208v18.8c0 47-17.3 92.4-48.5 127.6l-7.4 8.3c-8.4 9.4-10.4 22.9-5.3 34.4S19.4 416 32 416H416c12.6 0 24-7.4 29.2-18.9s3.1-25-5.3-34.4l-7.4-8.3C401.3 319.2 384 273.9 384 226.8V208c0-77.4-55-142-128-156.8V32c0-17.7-14.3-32-32-32zm45.3 493.3c12-12 18.7-28.3 18.7-45.3H224 160c0 17 6.7 33.3 18.7 45.3s28.3 18.7 45.3 18.7s33.3-6.7 45.3-18.7z" />
            </svg>
          </span>
          <Link to={"/profile"}>
            <span>프로필</span>
          </Link>
        </NavRoute>
      ) : (
        <NavRoute>
          <Link to={"/login"}>
            <span>로그인</span>
          </Link>
          <Link to={"/join"}>
            <span>회원가입</span>
          </Link>
        </NavRoute>
      )}
    </Nav>
  );
}

export default Header;
