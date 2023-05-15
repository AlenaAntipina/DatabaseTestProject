package pages.data;

public enum Interest {
    SELECT_ALL("Select all"),
    UNSELECT_ALL("Unselect all");

    private String interest;
    private Interest(String interest) {
        this.interest = interest;
    }

    public String getInterest(){
        return interest;
    }
}
