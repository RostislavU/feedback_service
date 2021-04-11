package ru.experts.feedback.service;

import ru.experts.feedback.entity.Feedback;
import ru.experts.feedback.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

        @Autowired
        private final FeedbackRepository feedbackRepository;

        public FeedbackService(FeedbackRepository feedbackRepository){
            this.feedbackRepository = feedbackRepository;
        }

        public void insert(Feedback feedback) {
            feedbackRepository.save(feedback);
        }

        public List<Feedback> findAll(){
            return feedbackRepository.findAll();
        }

        public List<Feedback> findAllByServiceName(){
            return feedbackRepository.findAllByServiceName();
        }
    }

