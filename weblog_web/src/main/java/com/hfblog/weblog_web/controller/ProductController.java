package com.hfblog.weblog_web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



//在没有全局异常管理的情况下，每个控制器或 service 服务中可能都会有各种
// try-catch 代码块来捕获和处理异常。这样会导致以下问题：
//代码重复：相同的异常处理逻辑会在多处重复出现。
//不一致的响应格式：不同的开发人员可能采用不同的方式来处理同一种异常，从而导致响应格式不统一。
//增加维护成本：未来对异常处理逻辑的任何更改都需要在多个地方进行修改。
//可读性差：try-catch 块使得主要的业务逻辑被异常处理代码包围，这可能会让代码的主要逻辑不够明显，
//降低代码的可读性。
//通过实现全局异常管理，我们可以避免上述问题，确保应用在出现异常时始终有一致和统一的行为。

@RestController
public class ProductController {

    @GetMapping("/product/{id}")
    public ResponseEntity<String> getProduct(@PathVariable String id) {
        try {
            int productId = Integer.parseInt(id);

            // 判断产品 ID 是否合规
            if (productId <= 0) {
                throw new IllegalArgumentException("Product ID must be greater than 0");
            }

            // 假设这里是一个查找产品的逻辑
            String productInfo = "Product Info for ID: " + id;

            return ResponseEntity.ok(productInfo);
        } catch (NumberFormatException e) {
            // 捕获 ID 不是数字的情况
            return ResponseEntity.badRequest().body("Invalid Product ID format");
        } catch (IllegalArgumentException e) {
            // 捕获产品 ID 小于等于0的情况
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // 捕获所有其他类型的异常
            return ResponseEntity.status(500).body("An unexpected error occurred");
        }
    }
}
