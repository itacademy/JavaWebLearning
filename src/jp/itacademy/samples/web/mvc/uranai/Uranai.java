package jp.itacademy.samples.web.mvc.uranai;

public class Uranai {

    private String bloodType;

    public Uranai(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Object getResult() {
        switch (bloodType) {
        case "A":
            return "だいきちー";
        case "B":
            return "ちょうだいきちー";
        case "O":
            return "まあまあー";
        case "AB":
            return "だいきょうー　がーん";
        default:
            return "そんな血液型ありません";
        }
    }
}
