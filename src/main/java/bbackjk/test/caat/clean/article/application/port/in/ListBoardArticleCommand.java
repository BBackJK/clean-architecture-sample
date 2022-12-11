package bbackjk.test.caat.clean.article.application.port.in;


public class ListBoardArticleCommand {

    private final int DEFAULT_PAGE_SIZE = 10;

    private int pageIndex;
    private int pageSize;
    private String searchType;
    private String searchValue;

    public int getStartPage() {
        return (pageIndex - 1) * pageSize;
    }

    public void initPage(int pageSize) {
        this.initPage();
        this.pageSize = pageSize;
    }

    public void initPage() {
        if (this.pageIndex < 1) {
            this.pageIndex = 1;
        }

        if (this.pageSize < 1) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }
}
