package project.project.dto;

public class ArticleForm {
    private String title; // 제목을 받을 필드
    private String context; // 내용을 받을 필드
    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
    public ArticleForm(String title, String context) {
        this.title = title;
        this.context = context;
    }
    // 데이터를 잘 받았는지 확인할 toString() 메서드 추가
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
