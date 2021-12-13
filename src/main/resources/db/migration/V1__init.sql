create table if not exists products (id bigserial primary key, name varchar(255), cost int, info varchar(255) );

insert into products (name, cost, info)
values
('bacon', 100, 'Sale'),
('beef', 80, 'Sale'),
('chicken', 90, 'Sale'),
('duck', 100, 'Sale'),
('ham', 80, 'Sale'),
('lamb', 90, 'Sale'),
('liver', 100, 'Sale'),
('meat', 80, 'Sale'),
('mutton', 90, 'Sale'),
('ox tongue', 100, 'Sale'),
('patridge', 80, 'Sale'),
('pork', 90, 'Sale'),
('poultry', 100, 'Sale'),
('sausage', 80, 'Sale'),
('tenderloin', 90, 'Sale'),
('turkey', 100, 'Sale'),
('veal', 80, 'Sale'),
('venison', 90, 'Sale'),
('cod', 80, 'Sale'),
('eel', 90, 'Sale');