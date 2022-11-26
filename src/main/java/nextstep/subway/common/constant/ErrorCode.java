package nextstep.subway.common.constant;

public enum ErrorCode {

    노선_또는_지하철명은_비어있을_수_없음("[ERROR] 노선 또는 지하철역명은 비어있을 수 없습니다."),
    노선색상은_비어있을_수_없음("[ERROR] 노선색상은 비어있을 수 없습니다."),
    상행종착역은_비어있을_수_없음("[ERROR] 상행종착역은 비어있을 수 없습니다."),
    하행종착역은_비어있을_수_없음("[ERROR] 하행종착역은 비어있을 수 없습니다."),
    노선거리는_0보다_작거나_같을_수_없음("[ERROR] 노선거리는 0보다 작거나 같을 수 없습니다."),
    노선_정보가_없음("[ERROR] 노선 정보는 비어있을 수 없습니다."),
    해당하는_노선_없음("[ERROR] 해당하는 노선이 없습니다."),
    구간의_상행역과_하행역이_동일할_수_없음("[ERROR] 구간의 상행역과 하행역은 동일할 수 없습니다."),
    이미_존재하는_구간("[ERROR] 이미 존재하는 구간입니다."),
    구간의_상행역과_하행역이_모두_노선에_포함되지_않음("[ERROR] 해당 구간의 상행역과 하행역은 모두 노선에 포함되지 않아 존재할 수 없는 구간입니다."),
    구간의_노선이_기존_구간들과_상이함("[ERROR] 해당 구간의 노선은 기등록된 구간들의 노선과 상이합니다."),
    존재하지_않는_역("[ERROR] 존재하지 않는 역입니다."),
    노선에_속한_구간이_하나이면_제거_불가("[ERROR] 노선에 속한 구간이 하나이므로 노선에서 역을 제거할 수 없습니다."),
    노선_내_존재하지_않는_역("[ERROR] 노선 내 존재하지 않는 역입니다."),
    출발역과_도착역은_연결되지_않음("[ERROR] 출발역에서 도착역으로 갈 수 있는 경로가 존재하지 않습니다."),
    출발역과_도착역이_서로_같음("[ERROR] 출발역과 도착역은 같을 수 없습니다."),
    경로는_비어있을_수_없음("[ERROR] 경로는 비어있을 수 없습니다."),
    해당_이메일을_가진_회원_없음("[ERROR] 해당 이메일을 가진 회원은 없습니다."),
    존재하지_않는_회원("[ERROR] 존재하지 않는 회원입니다."),
    나이는_0보다_작거나_같을_수_없음("[ERROR] 나이는 0보다 작거나 같을 수 없습니다.")
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
