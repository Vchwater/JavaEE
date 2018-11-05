package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Article;

public class Article_Dao {
	public boolean AddArticle(Article article) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into blog.article(name,title,date,likenum,look,content,image)values(?,?,?,?,?,?,?)");
			stmt.setString(1,article.getName());
			stmt.setString(2, article.getTitle());
			stmt.setDate(3, article.getDate());
			stmt.setInt(4, article.getLike());
			stmt.setInt(5, article.getLook());
			stmt.setString(6, article.getContent());
			stmt.setString(7, article.getImage());
			stmt.executeUpdate();
			conn.close();
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("博客添加失败");
		}
		return false;
	}
	public Article FindArticle(String id) {
		Article article = new Article();
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from blog.article where idarticle = ?");
			stmt.setInt(1, Integer.parseInt(id));
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				
				article.setId(result.getInt("idarticle"));
				article.setName(result.getString("name"));
				article.setTitle(result.getString("title"));
				article.setDate(result.getDate("date"));
				article.setLike(result.getInt("likenum"));
				article.setLook(result.getInt("look"));
				article.setContent(result.getString("content"));
				article.setImage(result.getString("image"));
			}
			return article;
		} catch (SQLException e) {
			System.out.println("FindArticle()失败");
			e.printStackTrace();
		}
		return null;
	}
	public List<Article> FindUserArticle(String name) {
		List<Article> list = new ArrayList<Article>();
		
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from blog.article where name = ?");
			stmt.setString(1, name);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Article article = new Article();
				article.setId(result.getInt("idarticle"));
				article.setName(result.getString("name"));
				article.setTitle(result.getString("title"));
				article.setDate(result.getDate("date"));
				article.setLike(result.getInt("likenum"));
				article.setLook(result.getInt("look"));
				article.setContent(result.getString("content"));
				article.setImage(result.getString("image"));
				list.add(article);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("FindUserArticle()失败");
			e.printStackTrace();
		}
		return null;
	}
	public List<Article> FindAllArticle() {
		List<Article> list = new ArrayList<Article>();
		
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from blog.article");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Article article = new Article();
				article.setId(result.getInt("idarticle"));
				article.setName(result.getString("name"));
				article.setTitle(result.getString("title"));
				article.setDate(result.getDate("date"));
				article.setLike(result.getInt("likenum"));
				article.setLook(result.getInt("look"));
				article.setContent(result.getString("content"));
				article.setImage(result.getString("image"));
				list.add(article);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("FindAllArticle()失败");
			e.printStackTrace();
		}
		return null;
	}
	public List<Article> FindAllArticle(String order) {
		List<Article> list = new ArrayList<Article>();
		
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from blog.article order by "+order+" desc");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Article article = new Article();
				article.setId(result.getInt("idarticle"));
				article.setName(result.getString("name"));
				article.setTitle(result.getString("title"));
				article.setDate(result.getDate("date"));
				article.setLike(result.getInt("likenum"));
				article.setLook(result.getInt("look"));
				article.setContent(result.getString("content"));
				article.setImage(result.getString("image"));
				list.add(article);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("FindAllArticle()失败");
			e.printStackTrace();
		}
		return null;
	}
	public void addlook(int idarticle) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("update blog.article set look=look+1  where idarticle=?");
			stmt.setInt(1,idarticle);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addlike(int idarticle) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("update blog.article set likenum=likenum+1  where idarticle=?");
			stmt.setInt(1,idarticle);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateArticle(Article article) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("update blog.article set title=?,content=?  where idarticle=?");
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			stmt.setInt(3,article.getId());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteArticle(String id) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from blog.article where idarticle=?");
			stmt.setInt(1,Integer.parseInt(id));
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
