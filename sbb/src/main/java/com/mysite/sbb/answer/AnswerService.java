package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	// 생성자를 통한 객체 주입 : DI
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	// 답변글을 저장하는 메소드, Controller 에서 Question 생성해서 아규먼트로 인풋
	// 답변 저장 시 작성자를 저장할 수 있도록 AnswerService를 수정 + author속성 추가
	public Answer create(Question question, String content, SiteUser author) {
		
		// Answer 객체를 생성 후 아규먼트로 넘어오는 값을 setter 주입
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		
		this.answerRepository.save(answer);
		
		return answer;
	}
	
	// 답변 아이디로 답변 조회
	public Answer getAnswer(Integer id) {
		
		Optional<Answer> answer = this.answerRepository.findById(id);
		
		if(answer.isPresent()) {
			
			return answer.get();
		}else {
			
			throw new DataNotFoundException("answer not found");
		}
	}
	
	// 답변의 내용으로 답변을 수정
	public void modify(Answer answer, String content) {
		
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		
		this.answerRepository.save(answer);
		
	}
	
	// 답변 삭제 기능
	public void delete(Answer answer) {
		this.answerRepository.delete(answer);
	}
	
	// 답변 추천인 저장
	public void vote(Answer answer, SiteUser siteUser) {
		
		answer.getVoter().add(siteUser);
		this.answerRepository.save(answer);
	}

}
