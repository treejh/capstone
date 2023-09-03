import { Link } from "react-router-dom";
import { styled } from "styled-components";

const Container = styled.footer`
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 62.5rem;
  background-color: ${(props) => props.theme.bgColor};
  padding: 6.25rem 0px 0px 0px;
`;

const FooterBox = styled.div`
  display: flex;
  width: 100%;
  height: 70%;
  justify-content: start;
  align-items: start;
  font-size: 0.938rem;
  opacity: 0.6;
  font-weight: 600;
  padding: 12.5rem;
  h2 {
    font-size: 1.563rem;
    font-weight: 600;
    margin-bottom: 3.125rem;
  }
  li,
  span {
    font-size: 1.25rem;
    margin-bottom: 1.875rem;
  }
`;

const FooterDetail = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 18.75rem;
`;
const FooterNav = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 18.75rem;
  height: auto;
`;
const FooterEtc = styled.div``;

const SiteDetail = styled.div`
  display: flex;
  background-color: ${(props) => props.theme.bgColor};
  width: 100%;
  height: 30%;
  border-top: 0.063rem solid rgba(0, 0, 0, 0.2);
  padding: 2.5rem 12.5rem 12.5rem 12.5rem;
  span {
    font-size: 1.25rem;
    opacity: 0.7;
    font-weight: 600;
  }
`;

function Footer() {
  return (
    <Container>
      <FooterBox>
        <FooterDetail>
          <h2>캡스톤 디자인</h2>
          <span>etc</span>
        </FooterDetail>
        <FooterNav>
          <h2>Navigation</h2>
          <ul>
            <Link to={"/"}>
              <li>홈</li>
            </Link>
            <Link to={"/chat"}>
              <li>채팅</li>
            </Link>
            <Link to={"/createproject"}>
              <li>프로젝트 생성</li>
            </Link>
            <Link to={"/profile"}>
              <li>프로필</li>
            </Link>
          </ul>
        </FooterNav>
        <FooterEtc>
          <h2>Etc</h2>
        </FooterEtc>
      </FooterBox>
      <hr />
      <SiteDetail>
        <span>2023 ~ &copy; 캡스톤 디자인 프로젝트 매칭 플랫폼</span>
      </SiteDetail>
    </Container>
  );
}

export default Footer;
