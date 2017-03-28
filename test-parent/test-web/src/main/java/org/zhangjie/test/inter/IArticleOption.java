package org.zhangjie.test.inter;

import java.util.List;

public interface IArticleOption<T> {
	List<T> selectUserArticles(int id);
}
