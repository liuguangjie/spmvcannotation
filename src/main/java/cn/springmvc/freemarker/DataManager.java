package cn.springmvc.freemarker;

import cn.springmvc.cache.SystemCacheManager;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by free on 17-2-12.
 */
public class DataManager implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        return SystemCacheManager.getInstance().getDatas();
    }
}
