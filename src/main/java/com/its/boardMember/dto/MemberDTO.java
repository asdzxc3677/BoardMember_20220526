package com.its.boardMember.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id; //회원번호
    private String memberId; //회원아이디
    private String memberPassword; //회원비번
    private String memberName; //회원이름
    private int memberAge; //회원나이
    private String memberPhone; //회원폰번호
}
