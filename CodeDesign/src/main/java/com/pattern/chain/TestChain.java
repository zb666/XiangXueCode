package com.pattern.chain;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class TestChain implements FilterChain {

    private final List<? extends Filter> chainFilters;

    private FilterChain filterChain;

    private int currentPosition = 0;

    public TestChain(FilterChain filterChain,List<? extends Filter> chainFilters) {
        this.filterChain = filterChain;
        this.chainFilters = chainFilters;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        //如果是当前的一环
        if(this.currentPosition == chainFilters.size()){
            this.filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ++this.currentPosition;
            //不是自己，则交由其他链处理
            Filter nextFilter = chainFilters.get(currentPosition-1);
            nextFilter.doFilter(servletRequest,servletResponse,this);
        }
    }
}
