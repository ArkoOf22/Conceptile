CREATE TABLE app_user (
                        id INT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        total_questions_answered INT,
                        correct_answers INT,
                        incorrect_answers INT
);


CREATE TABLE question (
                          id INT PRIMARY KEY,
                          question_text VARCHAR(255) NOT NULL,
                          option_a VARCHAR(100) NOT NULL,
                          option_b VARCHAR(100) NOT NULL,
                          option_c VARCHAR(100) NOT NULL,
                          option_d VARCHAR(100) NOT NULL,
                          correct_option CHAR(1) NOT NULL CHECK (correct_option IN ('A', 'B', 'C', 'D'))
);
