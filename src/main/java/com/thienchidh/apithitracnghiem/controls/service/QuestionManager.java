package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.CauHoiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.FavoriteRepo;
import com.thienchidh.apithitracnghiem.model.entities.CauHoi;
import com.thienchidh.apithitracnghiem.model.entities.Favorite;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.ListQuestions;
import com.thienchidh.apithitracnghiem.model.responses.Question;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class QuestionManager {
    private CauHoiRepo cauHoiRepo;
    private FavoriteRepo favoriteRepo;

    public ListQuestions getListQuestionNormal(SinhVien sinhVienServer, int startId) {

        class LocalRandom {
            Random random = new Random();

            private String randomResult() {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 12; ++i) {
                    result.append((char) (random.nextInt(26) + 'a'));
                }
                return result.toString();
            }

            private String randomDirection() {
                return random.nextBoolean() ? "-1" : "1";
            }

            private int randomPosition(String result) {
                return random.nextInt(result.length());
            }

            private String fillAnswer(String resultRandom, String direction, int pos, char result) {
                char[] chars = resultRandom.toCharArray();

                if (direction.equals("-1")) {
                    chars[pos - 1] = result;
                } else {
                    chars[chars.length - pos] = result;
                }

                return new String(chars);
            }
        }


        LocalRandom localRandom = new LocalRandom();

        List<Question> list = new ArrayList<>();

        Page<CauHoi> all = cauHoiRepo.findAll(PageRequest.of(startId / 30, 30));
        List<CauHoi> content = all.getContent();
        for (CauHoi cauHoi : content) {

            String direction = localRandom.randomDirection();
            String firstResult = localRandom.randomResult();
            int pos = localRandom.randomPosition(firstResult);
            char correctAns = cauHoi.getDapAnDung().charAt(0);// a|b|c|d

            String result = localRandom.fillAnswer(firstResult, direction, pos, correctAns);

            Question question = Question.builder()
                    .id(cauHoi.getId())
                    .content(cauHoi.getContent())
                    .dapAnA(cauHoi.getDapAnA())
                    .dapAnB(cauHoi.getDapAnB())
                    .dapAnC(cauHoi.getDapAnC())
                    .dapAnD(cauHoi.getDapAnD())
                    .dapAnE(cauHoi.getDapAnE())
                    .dapAnF(cauHoi.getDapAnF())
                    .direction(direction)
                    .position(pos)
                    .dapAnDung(result)
                    .rate(cauHoi.getRate())
                    .thuocChuong(cauHoi.getThuocChuong())
                    .isFavorite(favoriteRepo.findAll(Example.of(new Favorite(0, sinhVienServer, cauHoi))).isEmpty() ? 0 : 1)
                    .build();

            list.add(question);
        }
        return new ListQuestions(list.size(), list);
    }

}
