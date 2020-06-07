package edu.bu.projectportal;

public class Project {

        private int id;
        private String title;
        private String summary;
        private String author;
        private Boolean isFavorite;
        private String link;
        private String keyword;
        private String additionalInformation;

        public static final String TRUE = "1";
        public static final String FALSE = "0";

    /*public Project() {
            title =" ";
            summary =" ";
            author = " ";
            isFavorite = FALSE;
            link = "";
            keyword = " ";
            additionalInformation = " ";
        }*/



        public Project(int id, String title, String summary, String author, Boolean isFavorite, String link, String keyword, String additionalInformation) {

            this.id = id;
            this.title = title;
            this.summary = summary;
            this.author = author;
            this.isFavorite = isFavorite;
            this.link = link;
            this.keyword = keyword;
            this.additionalInformation = additionalInformation;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getSummary() {
            return summary;
        }

        public String getAuthor() {
            return author;
        }

        public Boolean getFavorite() {
            return isFavorite;
        }

        public String getLink() {
            return link;
        }

        public String getKeyword() {
            return keyword;
        }

        public String getAdditionalInformation() {
            return additionalInformation;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setFavorite(Boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public void setLink(String link) {
            this.link = link;
        }

       public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void setAdditionalInformation(String additionalInformation) {
           this.additionalInformation = additionalInformation;
        }





    }
