package com.enjoy.cap3.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 09:07
 * Version: v1.0
 * Description: 自定义控件扫描类型
 */
public class CustomTypeFilter implements TypeFilter {

    private ClassMetadata classMetadata;

    /**
     * @param metadataReader        读取到当前正在扫描的类的信息
     * @param metadataReaderFactory 可以读取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata data = metadataReader.getAnnotationMetadata();
        // 获取正在扫描的类的信息
        classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源（类路径等）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("-->" + className);
        if (className.contains("order")) {
            // 类名包含er的时候过滤成功
            return true;
        }
        return false;
    }
}
