# taskGameTest
Console Game
В игре создается отряд определенной расы, состоящий из одного мага, трех лучников и четырех бойцов.
Предусмотрено четыре расы: эльфы, люди, орки, нежить. Эльфы и люди играют против орков и нежити.

В начале игры случайным образом создаются два враждующих отряда той или иной расы.
Все персонажи отряда делятся на две группы: обычные и привилегированные (с улучшенными показателями). Персонаж при наложении на него улучшения перемещается в привилегированную группу. Величина наносимого урона для персонажей привилегированной группы увеличивается в полтора раза.

Порядок ходов для рас определяется случайным образом. За один ход каждый персонаж отряда может выполнить действие (действие определяется случайным образом): сначала из привилегированной группы, а если она пуста, тогда из общего списка персонажей отряда рандомно. Персонаж из привилегированной группы после выполнения одного действия перемещается в общую группу.

Возможности персонажей:

    Раса эльфов:
        маг:
            наложение улучшения на персонажа своего отряда
            нанесение урона персонажу противника магией на 10 HP
        лучник:
            стрелять из лука (нанесение урона 7 HP)
            атаковать противника (нанесение урона 3 HP)
        воин:
            атаковать мечом (нанесение урона 15 HP)
    Раса людей:
        маг:
            наложение улучшения на персонажа своего отряда.
            атаковать магией (нанесение урона 4 HP)
        арбалетчик:
            стрелять из арбалета (нанесение урона 5 HP)
            атаковать (нанесение урона 3 HP)
        воин:
            атаковать мечом (нанесение урона 18 HP)
    Раса орков:
        шаман:
            наложение улучшения на персонажа своего отряда.
            наложение проклятия (снятие улучшения с персонажа противника для следующего хода)
        лучник:
            стрелять из лука (нанесение урона 3 HP)
            удар клинком (нанесение урона 2 HP)
        гоблин:
            атака дубиной (нанесение урона 20 HP)
    Раса нежити:
        некромант:
            наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход)
            атака (нанесение урона 5 HP)
        охотник:
            стрелять из лука (нанесение урона 4 HP)
            атаковать (нанесение урона 2 HP)
        зомби:
            удар копьем (нанесение урона 18 HP)

С начала игры каждый персонаж имеет уровень жизни равный 100 HP.
Выводить ход игры в консоль: вести статистику ходов с порядком ходов (кто, кого, нанесенный урон, умер). По завершении игры сохранять лог в файл.
