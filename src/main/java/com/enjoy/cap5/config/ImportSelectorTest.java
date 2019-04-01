package com.enjoy.cap5.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 17:46
 * Version: v1.0
 * Description:
 */
public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.enjoy.cap5.beans.Fish", "com.enjoy.cap5.beans.Pig"};
    }
}
