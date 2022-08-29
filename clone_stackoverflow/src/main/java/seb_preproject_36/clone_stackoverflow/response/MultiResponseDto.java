package seb_preproject_36.clone_stackoverflow.response;

import lombok.Getter;

import java.util.List;

@Getter
public class MultiResponseDto<T> {
    private List<T> data;
    //private PageInfo pageInfo;


    public MultiResponseDto(List<T> data) {
        this.data = data;
        //this.pageInfo = new PageInfo(page.getNumber() + 1,
        //                page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
