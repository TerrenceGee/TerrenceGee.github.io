package com.iie.extract.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "分页结果")
@Data
public final class IPageResult<T> implements Serializable {

    @Schema(description = "数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<T> list;

    @Schema(description = "总量", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long total;

    private Integer pageSize;

    private Integer pageNum;

    public IPageResult() {
    }

    public IPageResult(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public IPageResult(Long total) {
        this.list = new ArrayList<>();
        this.total = total;
    }

    public static <T> IPageResult<T> empty() {
        return new IPageResult<>(0L);
    }

    public static <T> IPageResult<T> empty(Long total) {
        return new IPageResult<>(total);
    }

    public IPageResult(IPage<T> page) {
        this.list = page.getRecords();
        this.total = page.getTotal();
        this.pageSize = Math.toIntExact(page.getSize());
        this.pageNum = Math.toIntExact(page.getCurrent());
    }

}
