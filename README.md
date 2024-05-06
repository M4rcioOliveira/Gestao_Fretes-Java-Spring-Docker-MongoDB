# AZShip - Gestão de Fretes - *Done*

## Descrição
O sistema de gestão de fretes da AZShip é uma solução projetada em uma *Arquitetura Hexagonal* para gerenciar com eficácia as informações de frete de seus clientes. Sua capacidade de lidar com a diversidade de informações entre diferentes clientes, adaptando-se a conjuntos exclusivos de propriedades de frete, destaca-se como uma de suas principais características. Essa flexibilidade permite que a aplicação armazene e manipule as informações de forma personalizada, atendendo às necessidades específicas de cada cliente.

## Pré-requisitos
Antes de executar este projeto, certifique-se de ter o seguinte instalado em sua máquina:
- Java (17)
- Docker

## Instalação/Utilização
1. Clone este repositório: ***git clone*** *https://github.com/M4rcioOliveira/adm-azs-shipping.git/*
2. Navegue até o diretório raiz do projeto:  ***adm-azs-shipping***
3. Dentro do diretório execute a aplicação rodando o comando docker no terminal : ***docker-compose up --build***
4. Utilize a ***collection*** disponível em *https://drive.google.com/file/d/1U5ouFjCIak1SmW9kpJ6WXloJcgTJ4Q9n/view?usp=sharing* ou acesse o ***swagger*** em *http://localhost:8080/swagger-ui/index.html*
5. **OBS:** A aplicação consome uma api mock de clientes fictícios para a associação do cliente ao frete na hora do cadastro. Ao cadastrar um novo frete, deve ser informado no campo cliente_id um dos  ids disponibilizados no mock em https://run.mocky.io/v3/11929995-fd80-4d4d-8944-ad72ea9e3501.

## Tecnologias Utilizadas
- Spring Framework
- Java
- Maven
- Feign
- MongoDB
- Docker
- Swagger
