package com.rookie.im.user.domain.resp;


import lombok.Data;

import java.util.List;

@Data
public class ImportUserResp {

    //用户导入错误返回
    private List<String> errorImportUserNames;
}
