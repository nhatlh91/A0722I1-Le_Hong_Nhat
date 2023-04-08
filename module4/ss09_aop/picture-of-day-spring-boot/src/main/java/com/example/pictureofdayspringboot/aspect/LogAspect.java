package com.example.pictureofdayspringboot.aspect;

import com.example.pictureofdayspringboot.model.Comment;
import exception.CommentException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
 private Logger logger = Logger.getLogger(LogAspect.class.getName());

 @Pointcut("execution(* com.example.pictureofdayspringboot.service.CommentServiceImpl.save(..))")
 public void commentService(){};

 @AfterThrowing(value = "commentService()", throwing = "ex")
 public void saveError(JoinPoint point, CommentException ex){
  Comment comment = ex.getComment();
  String methodName = point.getSignature().getName();
  logger.info("After throwing call method: " + methodName);
  logger.warning(ex.getMessage());
  logger.warning(comment.getAuthor());
  logger.warning(comment.getComment());
  logger.warning(comment.getDate().toString());
 }

}
