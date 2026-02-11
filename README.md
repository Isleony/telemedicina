# Hospital Management System

Sistema completo de gestão hospitalar com módulos de oncologia e telemedicina.

## 🚀 Tecnologias

### Backend
- Java 21 (LTS)
- Spring Boot 3.2.2
- PostgreSQL / H2
- Maven 3.9.12

### Frontend
- React 18
- TypeScript 5
- Vite 5
- Tailwind CSS 3
- React Router 6

## 📦 Instalação

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```

## 🌐 Deploy

### Backend
O backend pode ser hospedado em qualquer serviço que suporte Java 21:
- Azure App Service
- AWS Elastic Beanstalk
- Heroku
- Railway

### Frontend (Vercel)
1. Conecte seu repositório no Vercel
2. Configure o diretório raiz como `frontend`
3. Build Command: `npm run build`
4. Output Directory: `dist`
5. Install Command: `npm install`

## 🔗 API Endpoints

- Backend: http://localhost:8080
- Frontend: http://localhost:3000
- H2 Console: http://localhost:8080/h2-console

## 📱 Funcionalidades

- ✅ Dashboard com estatísticas
- ✅ Gestão de Pacientes
- ✅ Agendamentos de Consultas
- ✅ Telemedicina (Consultas Virtuais)
- ✅ Módulo de Oncologia
- ✅ Controle de Leitos
- ✅ Prontuários Médicos
- ✅ Gestão de Inventário

## 🔐 Segurança

- Spring Security
- JWT Authentication
- Validação de dados
- Proteção contra SQL Injection

## 📄 Licença

MIT
