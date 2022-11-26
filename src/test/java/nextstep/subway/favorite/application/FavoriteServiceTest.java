package nextstep.subway.favorite.application;

import static nextstep.subway.line.domain.LineTestFixture.createLine;
import static nextstep.subway.line.domain.SectionTestFixture.createSection;
import static nextstep.subway.member.domain.MemberTestFixture.createLoginMember;
import static nextstep.subway.member.domain.MemberTestFixture.createMember;
import static nextstep.subway.station.domain.StationTestFixture.createStation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import nextstep.subway.auth.domain.LoginMember;
import nextstep.subway.favorite.domain.Favorite;
import nextstep.subway.favorite.domain.FavoriteRepository;
import nextstep.subway.favorite.dto.FavoriteResponse;
import nextstep.subway.line.domain.Line;
import nextstep.subway.member.domain.Member;
import nextstep.subway.station.domain.Station;
import nextstep.subway.station.dto.StationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("즐겨찾기 관련 서비스 테스트")
@ExtendWith(MockitoExtension.class)
public class FavoriteServiceTest {

    @Mock
    private FavoriteRepository favoriteRepository;

    @InjectMocks
    private FavoriteService favoriteService;

    private Line 칠호선;
    private Line 신분당선;
    private Line 이호선;
    private Line 삼호선;
    private Station 이수역;
    private Station 반포역;
    private Station 강남역;
    private Station 양재역;
    private Station 교대역;
    private Station 남부터미널역;
    private Member 회원;
    private LoginMember 로그인한_회원;

    @BeforeEach
    public void setUp() {
        이수역 = createStation("이수역");
        반포역 = createStation("반포역");
        강남역 = createStation("강남역");
        양재역 = createStation("양재역");
        교대역 = createStation("교대역");
        남부터미널역 = createStation("남부터미널역");

        칠호선 = createLine("칠호선", "bg-khaki", 이수역, 반포역, 20);
        신분당선 = createLine("신분당선", "bg-red", 강남역, 양재역, 10);
        이호선 = createLine("이호선", "bg-green", 교대역, 강남역, 10);
        삼호선 = createLine("삼호선", "bg-orange", 교대역, 양재역, 5);
        삼호선.addSection(createSection(삼호선, 교대역, 남부터미널역, 3));

        회원 = createMember("email@email.com", "password", 28);
        로그인한_회원 = createLoginMember(회원);
    }

    @DisplayName("즐겨찾기를 생성한다.")
    @Test
    void createFavorite() {

    }

    @DisplayName("즐겨찾기 생성 시, 존재하지 않는 지하철역을 시작점으로 하면 예외를 발생시킨다.")
    @Test
    void createFavoriteThrowErrorWhenSourceStationIsNotExists() {
    }

    @DisplayName("즐겨찾기 생성 시, 존재하지 않는 지하철역을 종착점으로 하면 예외를 발생시킨다.")
    @Test
    void createFavoriteThrowErrorWhenTargetStationIsNotExists() {

    }

    @DisplayName("즐겨찾기 전체 목록을 조회한다.")
    @Test
    void findFavorites() {
        // given
        when(favoriteRepository.findByMemberId(회원.getId())).thenReturn(
                Arrays.asList(new Favorite(회원, 강남역, 양재역), new Favorite(회원, 교대역, 이수역)));

        // when
        List<FavoriteResponse> favorites = favoriteService.findFavorites(로그인한_회원);

        // then
        assertAll(
                () -> assertThat(favorites).hasSize(2),
                () -> assertThat(favorites.stream().map(FavoriteResponse::getSource).map(StationResponse::getName))
                        .containsExactlyElementsOf(Arrays.asList("강남역", "교대역")),
                () -> assertThat(favorites.stream().map(FavoriteResponse::getTarget).map(StationResponse::getName))
                        .containsExactlyElementsOf(Arrays.asList("양재역", "이수역"))
        );
    }

    @DisplayName("즐겨찾기를 삭제한다.")
    @Test
    void deleteFavorite() {

    }

    @DisplayName("존재하지 않는 즐겨찾기를 삭제하려하면 예외를 발생시킨다.")
    @Test
    void deleteFavoriteThrowErrorWhenFavoriteIsNotExists() {

    }
}
