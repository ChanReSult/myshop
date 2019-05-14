package com.result.my.shop.web.api.web.controller.v1;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.api.web.controller
 * @ClassName: TbcontentController
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/7 11:45
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.domain.TbContent;
import com.result.my.shop.web.api.service.TbContentService;
import com.result.my.shop.web.api.web.dto.TbcontentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-07 11:45
 **/
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbcontent(Long id) {
        TbContent tbContent = null;
        if (id == null) {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 根据类别Id 查询内容列表
     *
     * @param catagoryId
     * @return
     */
    @RequestMapping(value = "{catagoryId}", method = RequestMethod.GET)
    public BaseResult categoryId(@PathVariable(value = "catagoryId") Long catagoryId) {
        List<TbcontentDTO> tbcontentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(catagoryId);

        if (tbContents != null && tbContents.size() > 0) {
            tbcontentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbcontentDTO dto = new TbcontentDTO();
                BeanUtils.copyProperties(tbContent, dto);
                tbcontentDTOS.add(dto);
            }

        }
        return BaseResult.success("成功", tbcontentDTOS);
    }
}
