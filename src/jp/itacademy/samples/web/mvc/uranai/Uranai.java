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
            return "���������[";
        case "B":
            return "���傤���������[";
        case "O":
            return "�܂��܂��[";
        case "AB":
            return "�������傤�[�@���[��";
        default:
            return "����Ȍ��t�^����܂���";
        }
    }
}
