package baseball.view;

import baseball.domain.Score;

public class OutputView {
    public static void enterNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameEndOutput(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void gameRetryAnswer(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printError(String errorMessage){
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void inningResultOutput(Score score){
        int strike = score.getStrike();
        int ball = score.getBall();
        String strikeResult = strikeFormatting(strike);
        String ballResult = ballFormatting(ball);
        String nothingResult = nothingFormatting(strike, ball);
        System.out.println(strikeResult + ballResult + nothingResult);
    }

    private static String strikeFormatting(int strike){
        if(strike > 0){
            return strike + "스트라이크 ";
        }
        return "";
    }

    private static String ballFormatting(int ball){
        if(ball > 0){
            return ball + "볼 ";
        }
        return "";
    }

    private static String nothingFormatting(int strike, int ball){
        if(strike == 0 && ball == 0){
            return "낫싱";
        }
        return "";
    }


}
