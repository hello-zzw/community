package life.lzjt.community.mapper;

import life.lzjt.community.model.Comment;
import life.lzjt.community.model.CommentExample;
import life.lzjt.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment record);
}