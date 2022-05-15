package com.jgcardelus.exercise.join;

public class UserDocumentJoin {
    private Long userId;
    private String user;
    private String comment;
    private Long docId;
    private String doc;
    
    public UserDocumentJoin(Long userId, String user, String comment, Long docId, String doc) {
        this.userId = userId;
        this.user = user;
        this.comment = comment;
        this.docId = docId;
        this.doc = doc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((docId == null) ? 0 : docId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDocumentJoin other = (UserDocumentJoin) obj;
        if (docId == null) {
            if (other.docId != null)
                return false;
        } else if (!docId.equals(other.docId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
}
