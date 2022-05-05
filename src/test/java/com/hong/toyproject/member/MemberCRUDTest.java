package com.hong.toyproject.member;

import com.hong.toyproject.ToyprojectApplicationTests;
import com.hong.toyproject.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemberCRUDTest extends ToyprojectApplicationTests {

    @MockBean
    protected MemberRepository memberRepository;

    @Test
    public void memberFindOneMemberTest() throws Exception {
        //Given
        String url = "/api/v1/members/1";

        Member member = Member.builder()
                .memberId(1L)
                .name("testName")
                .build();

        given(memberRepository.findById(1L))
                .willReturn(
                        Optional.of(member)
                );

        //When
        ResultActions resultActions = this.mockMvc.perform(get(url));

        //Then
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("memberId").value(1L))
                .andExpect(jsonPath("name").value("testName"));
    }
}
