package exchange_rates;

import java.util.Arrays;

public class Organization {
    private String title;
    private Currency[] currency;

    public Organization(String title, Currency [] currency) {
        this.title = title;
        this.currency = currency;
    }

     static class Currency {
        private String id;
        private double br;
        private double ar;

         public Currency() {
         }

         public Currency(String id, double br, double ar) {
             this.id = id;
             this.br = br;
             this.ar = ar;
         }

         public String getId() {
            return id;
        }

        public double getBr() {
            return br;
        }

        public double getAr() {
            return ar;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBr(double br) {
            this.br = br;
        }

        public void setAr(double ar) {
            this.ar = ar;
        }

        @Override
        public String toString() {
            return "Currency{" +
                    "id='" + id + '\'' +
                    ", br=" + br +
                    ", ar=" + ar +
                    '}';
        }
    }


    public Organization() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCurrency(Currency[] currency) {
        this.currency = currency;
    }

    public Currency[] getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", currency=" + Arrays.toString(currency) +
                '}';
    }
}
