package cn.xupt.reward.framework.web.controller;

import java.util.List;

import cn.xupt.reward.common.utils.StringUtils;
import cn.xupt.reward.common.utils.security.ShiroUtils;
import cn.xupt.reward.framework.web.page.PageDomain;
import cn.xupt.reward.framework.web.page.TableDataInfo;
import cn.xupt.reward.framework.web.page.TableSupport;
import cn.xupt.reward.project.user.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * web层通用数据处理
 * 
 * @author ZH
 */
public class BaseController
{
    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public User getUser()
    {
        return ShiroUtils.getUser();
    }

    public void setUser(User user)
    {
        ShiroUtils.setUser(user);
    }

//    public Long getUserId()
//    {
//        return getUser().getUserId();
//    }
//
//    public String getLoginName()
//    {
//        return getUser().getLoginName();
//    }
}
