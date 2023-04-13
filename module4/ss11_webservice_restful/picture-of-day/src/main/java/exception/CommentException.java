package exception;

import com.example.pictureofdayspringboot.model.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentException extends RuntimeException{
    private Comment comment;

    public CommentException(String message, Comment comment){
        super(message);
        this.comment = comment;
    }
}
