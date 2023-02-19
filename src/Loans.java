public class Loans {

    private double loanTotal;
    private double debt;
    private double interestRate = 1.25;


    public Loans(double tot) {
        loanTotal = tot;
        debt = loanTotal * interestRate;
    }

    public Loans(Loans loan) {
        loanTotal = loan.getLoanTotal();
        debt = loan.getDebt();
        interestRate = loan.getInterestRate();
    }

    public void payment(double pay) {
        debt -= pay;
    }

    public void withdrawl(double take) {
        loanTotal += take;
        debt += take;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getDebt() {
        return debt;
    }

    public double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(double loan) {
        loanTotal = loan;
        debt = loan * interestRate;
    }

    public String toString() {
        return String.format("""
                Loan total: $%.02f
                Dept remaining: $%.02f""", loanTotal, debt);
    }
}
