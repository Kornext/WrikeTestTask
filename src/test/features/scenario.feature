# language: ru
@all
Функция: Проверка работоспособности сайта

  @success
  Сценарий:
      Когда пользователь нажимает на кнопку (Get started for free)
      Тогда появляется окно
      Когда пользователь заполняет поле (Enter Your Business email)
        И нажимает на кнопку (Create My Wrike Account)
      Тогда переход на страницу recent
      Когда пользователь заполняет случайным образом поля
        И нажимает на кнопку (Submit Result)
      Тогда проверяется, что ответы приняты
      Когда пользователь нажимает на кнопку (Resend email)
      Тогда проверяем, что сообщение отправилось









#Open url: wrike.com;

#Click "Get started for free" button near "Login" button;

#Fill in the email field with random generated value of email with
#   mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);

#Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;

#Fill in the Q&A section at the left part of page (like random generated answers)
#   + check with assertion that your answers are submitted;

#Click on "Resend email" + check it with assertion;

#Check that section "Follow us" at the site footer contains the "Twitter" button
#   that leads to the correct url and has the correct icon.
