# CS492 Probabilistic Programming, Spring 2018, KAIST 

This is a webpage of the course "CS492 Probabilistic Programming", which is offered at the KAIST CS department in the spring of 2018. The webpage will contain links to lecture slides and other course-related materials.

Probabilistic programming refers to the idea of developing a programming language for writing and reasoning about probabilistic models from machine learning and statistics. Such a language comes with the implementation of several generic inference algorithms that answer various queries about the models written in the language, such as posterior inference and marginalisation. By providing these algorithms, a probabilistic programming language enables data scientists to focus on designing good models based on their domain knowledge, instead of building effective inference engines for their models, a task that typically requires expertise in machine learning, statistics and systems. Even experts in machine learning and statistics may get benefitted from such a probabilistic programming system because using the system they can easily explore highly advanced models.

This course has two goals. The first is to help students to be a good user of an expressive probabilistic programming language.  Throughout the course, we will use a particular language, called [Anglican](http://www.robots.ox.ac.uk/~fwood/anglican/), but we will emphasise general principles that apply to a wide range of existing probabilistic programming systems. The second goal is to expose the students to recent exciting results in probabilistic programming, which come from machine learning, statistics, programming languages, and probability theory.  

## 1. Important Announcements

## 2. Logistics

#### Evaluation

* Final exam (40%). Project (40%). Homework (20%).

#### Teaching Staffs

* Lecturer: [Hongseok Yang](https://cs.kaist.ac.kr/people/view?idx=552&kind=faculty&menu=160) (email: hongseok.yang@kaist.ac.kr, office hour: 6:00pm - 7:00pm on Tuesday at the room 3403 in the E3-1 building)
* TA: Kwonsoo Chae (email: kwonsoo.chae@gmail.com)

#### Place and Time

* Place: room 111 in the N1 building
* Time: 10:30am - 11:45am on Tuesday and Thursday from February 27 2018 until June 14 2018.
* Final Exam: 9:00am - 11:00am on June 14 2018 (Thursday) at the room 111 in the N1 building.


#### Online Discussion

* We will use KLMS. 

## 3. Tentative Plan

* 02/26 (Tue) - Introduction. 
* __**03/01 (Thu) - NO LECTURE.**__
* 03/06 (Tue) - Basics of Clojure and Tiny Bit of Anglican.
* 03/08 (Thu) - Posterior Inference, Basics of Anglican, and Importance Sampling. 
* 03/13 (Tue) - Posterior Inference, Basics of Anglican, and Importance Sampling. 
* 03/15 (Thu) - Generative Modelling with Anglican. 
* 03/20 (Tue) - Generative Modelling with Anglican. 
* 03/22 (Thu) - Generative Modelling with Anglican. 
* 03/27 (Tue) - Markov Chain Monte Carlo. 
* 03/29 (Thu) - Markov Chain Monte Carlo. 
* 04/03 (Tue) - Markov Chain Monte Carlo. 
* 04/05 (Thu) - Implementing Inference Algorithms for Probabilistic Programs. 
* 04/10 (Tue) - Implementing Inference Algorithms for Probabilistic Programs. 
* 04/12 (Thu) - Implementing Inference Algorithms for Probabilistic Programs. 
* __**04/17 (Tue), 04/19 (Thu) - NO LECTURES.**__
* 04/24 (Tue) - Denotational Semantics of Probabilistic Programs. 
* 04/26 (Thu) - Denotational Semantics of Probabilistic Programs. 
* 05/01 (Tue) - Denotational Semantics of Probabilistic Programs. 
* 05/03 (Thu) - Denotational Semantics of Probabilistic Programs. 
* 05/08 (Tue) - Amortised Inference. 
* 05/10 (Thu) - Amortised Inference. 
* 05/15 (Tue) - TBD
* 05/17 (Thu) - TBD
* __**05/22 (Tue) - NO LECTURE.**__
* 05/24 (Thu) - TBD
* 05/29 (Tue) - TBD
* 05/31 (Tue) - TBD
* 05/31 (Thu) - TBD
* 06/05 (Tue) - TBD
* 06/07 (Thu) - TBD
* __**06/12 (Tue), 06/14 (Thu) - NO LECTURES.**__

## 4. Studying Materials

Unfortunately we do not know of a good textbook that matches the topics of this course exactly.Studying the lecture slides and the homework exercises of the course is likely to be the most time-efficient way to catch up with this course. Also, at each lecture, we will give students pointers to the related papers. If a student wants to study more or finds the slides and the papers too terse or difficult, we recommend to have a look at the following online materials.

1. [Anglican website](http://www.robots.ox.ac.uk/~fwood/anglican/). In particular, students will learn a lot by trying examples in the site.
2. Goodman and Stuhlmuller's book "[The Design and Implementation of Probabilistic Programming Languages](http://dippl.org/)" This web-based book describes the implementation of WebPPL, a probabilistic programming language on top of JavaScript. Many techniques in the book are general and apply to other probabilistic programming languages.
3. [Forestdb.org](http://forestdb.org/) is a great source of interesting probabilistic programs. 
4. The online book "[Probabilistic Programming and Bayesian Methods for Hackers](https://github.com/CamDavidsonPilon/Probabilistic-Programming-and-Bayesian-Methods-for-Hackers)" describes Bayesian Machine Learning using a probabilistic programming system called PyMC.  Hongseok found this book easy to follow and good at explaining basics and intuitions. A more standard reference on machine learning is Bishop's book "Pattern Recognition and Machine Learning".

## 5. Group Project

A group project is a crucial part of this course. 2-3 students will form a 
project group, and they will carry out a project in Track A or in Track B:

1. **Track A**: A group develops an interesting application of Anglican or other probabilistic programming languages. The members of the group may attempt to find an efficient encoding of a highly complex probabilistic model (such as sequence memoizer) in Anglican,  or they may develop a new probabilistic model for a complex data set and analyse the data set, or they may try to find a novel use of probabilistic programming for solving well-known existing problems (such as figuring out secret key in some security protocol).
2. **Track B**: A group does small-scale research on probabilistic programming. The members of the group may choose to study a recent result on probabilistic programming or a related area and attempt to extend the result. Or they may consider a research question on probabilistic programming and try to come up with an answer. We are aware that failure is a norm in research. Thus, failed attempts to answer open questions and novel yet slower algorithms than existing ones are completely fine as long as they are analyzed carefully. We will suggest a few results and questions, although members of each group are free to choose one for themselves.

#### Concrete Tasks 

1. **[Deadline: midnight on Sep 11]** Form a group. Email it to both Byungsoo and Hongseok. 
2. **[Sep 21-22, Oct 26-27, Nov 9-10]** Participate in three evening meetings with Hongseok actively.
   1. First meeting: Choose candidate topics and plans before the meeting. 
   2. Second and third meetings: Have to explain the progress of a project and the challenges encountered so far.
3. **[Nov 27,29, Dec 4,6]** Present the result of your project. The presentation should include enough background materials so that it can be understood by fellow students.
4. **[Deadline: midnight on Dec 8]** Submit a report on the project. The report should not have more than 4 pages. 

#### Suggeted Topics in Track B

1. **Automatic Model Criticism and Automatic Model Revision.** People often arrive at a right model for a given data set after multiple revisions. Model criticism refers to techniques for evaluating the qualities of a model, and it plays a crucial role in this model-revision process. These model-revision techniques are partly automated in the probabilistic programming language Edward and the R language. The goal here is to study the state of the art in automatic model criticism, and to develop similar or better model-criticism functionalities for Anglican, a far more expressive probabilistic programming language than Edward and R. A more ambitious goal can be to develop a technique for automatically improving a model expressed as a probabilistic program by using these model-criticism functionalities. A good starting point is the [model-criticism web page](http://edwardlib.org/tutorials/criticism) of the Edward language. The book "Rethinking Statistics" also describes this process of model criticism and revision using several examples and information-theoretic estimates such as WAIC. This latter goal is similar to the objective of [the automated statistican project](https://www.automaticstatistician.com/index/), although this project uses a very different technique based on kernels.

2. **Variational Optimisation for Probabilistic Programs.** Suppose that we are given an Anglican function f that takes a real number and returns a real number randomly. We would like to find an input to this function that maximises the expectation of f(x). The goal here is to use the variational optimisation technique to solve this problem. The variational optimisation is explained in [this paper](https://arxiv.org/abs/1707.07113). [This paper](http://www.robots.ox.ac.uk/~twgr/assets/pdf/rainforth2016BOPP.pdf) on Bayesian optimisation for probabilistic programs is also related.

3. **Renyi-Divergence-Based Black-box Variational Inference for Probabilistic Programs.** A black-box variational inference (BBVI) is a powerful technique for computing an approximate posterior distribution of a probabilistic model. The standard BBVI has been implemented in Anglican, and it has played a crucial role for using Anglican for solving challenging stochastic planning problems. Our goal is to implement a recent variant of BBVI based on Renyi divergence for Anglican, and to analyse its cons and pros experimentally. The related papers are [the original BBVI paper](http://www.cs.columbia.edu/~blei/papers/RanganathGerrishBlei2014.pdf), [the Reni-divergence variational inference paper](https://arxiv.org/pdf/1602.02311.pdf), and [this paper on BBVI in Anglican](http://www.robots.ox.ac.uk/~fwood/assets/pdf/vandemeent16.pdf).

4. **Comparing the Cartesian Product of Quasi-Borel Spaces with That of Measurable Spaces.** This is a math problem. In the course, we will present quasi-Borel spaces and use them to set a new foundation of probability theory. Then, we will explain why this new foundation is more suitable for describing Anglican programs than the standard foundation based on measurable spaces. This topic is related to one such reason, which is that the cartesian product of quasi-Borel spaces is different from that of measurable spaces; intuitively, it is more permissive.  This difference is known, but we lack concrete examples that show this difference clearly. The goal here is to find such examples and to try to say something general about those examples. [Hongseok's LICS'17 paper](https://arxiv.org/pdf/1701.02547.pdf) is a good entry for this topic. 

5. **Automatic Synthesis of Probabilistic Programs.** The goal of this topic is to develop an efficient technique for finding a good probabilistic program for a given data set. Nori and his colleagues worked on this problem using the idea of sketch from the programming-language community. Understanding [their paper](https://www.microsoft.com/en-us/research/wp-content/uploads/2016/02/paper-5.pdf) and modifying their techniques in the context of Anglican can become a good starting point. [This paper](http://www.robots.ox.ac.uk/~fwood/assets/pdf/perov-agi-2016.pdf) by Perov and Wood and [this paper](https://arxiv.org/pdf/1110.5667.pdf) seem to be related.

