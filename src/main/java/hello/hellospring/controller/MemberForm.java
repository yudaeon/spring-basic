package hello.hellospring.controller;

//웹 등록화면에서 데이터를 전달받을 폼 객체
public class MemberForm {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}