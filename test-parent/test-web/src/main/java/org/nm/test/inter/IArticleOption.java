package org.nm.test.inter;

import java.util.List;

public interface IArticleOption<T> {
	List<T> selectUserArticles(int id);
}
