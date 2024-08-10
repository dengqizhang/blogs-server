package com.example.server.domin;

import lombok.Data;

/**
 * 文章对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class Article {
    private Long id;
    //文章内容(html格式)
    private String main;

}
