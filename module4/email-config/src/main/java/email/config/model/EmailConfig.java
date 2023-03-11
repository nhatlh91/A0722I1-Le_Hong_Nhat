package email.config.model;

public class EmailConfig {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String Signature;

    public EmailConfig() {
    }

    public EmailConfig(String language, int pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        Signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Override
    public String toString() {
        return "EmailConfig{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spamFilter=" + spamFilter +
                ", Signature='" + Signature + '\'' +
                '}';
    }
}
