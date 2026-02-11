import { Search, Plus, Edit, Eye } from 'lucide-react'

export default function Patients() {
  return (
    <div className="p-8">
      <div className="mb-8 flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Pacientes</h1>
          <p className="text-gray-600">Gerenciamento de pacientes cadastrados</p>
        </div>
        <button className="bg-primary-600 text-white px-4 py-2 rounded-lg flex items-center gap-2 hover:bg-primary-700">
          <Plus size={20} />
          Novo Paciente
        </button>
      </div>

      {/* Search Bar */}
      <div className="bg-white rounded-lg shadow p-4 mb-6">
        <div className="flex gap-4">
          <div className="flex-1 relative">
            <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400" size={20} />
            <input
              type="text"
              placeholder="Buscar por nome, CPF ou prontuário..."
              className="w-full pl-10 pr-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary-500"
            />
          </div>
          <button className="px-6 py-2 bg-primary-600 text-white rounded-lg hover:bg-primary-700">
            Buscar
          </button>
        </div>
      </div>

      {/* Patients Table */}
      <div className="bg-white rounded-lg shadow overflow-hidden">
        <table className="w-full">
          <thead className="bg-gray-50 border-b">
            <tr>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Nome</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">CPF</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Data Nasc.</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Telefone</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Status</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Ações</th>
            </tr>
          </thead>
          <tbody className="divide-y">
            <PatientRow
              name="Maria Silva Santos"
              cpf="123.456.789-00"
              birthDate="15/03/1980"
              phone="(11) 98765-4321"
              status="Ativo"
            />
            <PatientRow
              name="João Pedro Oliveira"
              cpf="987.654.321-00"
              birthDate="22/07/1975"
              phone="(11) 91234-5678"
              status="Ativo"
            />
            <PatientRow
              name="Ana Carolina Costa"
              cpf="456.789.123-00"
              birthDate="08/11/1992"
              phone="(11) 99876-5432"
              status="Ativo"
            />
          </tbody>
        </table>
      </div>
    </div>
  )
}

function PatientRow({ name, cpf, birthDate, phone, status }: {
  name: string
  cpf: string
  birthDate: string
  phone: string
  status: string
}) {
  return (
    <tr className="hover:bg-gray-50">
      <td className="px-6 py-4 whitespace-nowrap">
        <div className="font-medium text-gray-900">{name}</div>
      </td>
      <td className="px-6 py-4 whitespace-nowrap text-gray-600">{cpf}</td>
      <td className="px-6 py-4 whitespace-nowrap text-gray-600">{birthDate}</td>
      <td className="px-6 py-4 whitespace-nowrap text-gray-600">{phone}</td>
      <td className="px-6 py-4 whitespace-nowrap">
        <span className="px-2 py-1 text-xs font-medium bg-green-100 text-green-800 rounded-full">
          {status}
        </span>
      </td>
      <td className="px-6 py-4 whitespace-nowrap">
        <div className="flex gap-2">
          <button className="p-1 text-primary-600 hover:bg-primary-50 rounded">
            <Eye size={18} />
          </button>
          <button className="p-1 text-gray-600 hover:bg-gray-100 rounded">
            <Edit size={18} />
          </button>
        </div>
      </td>
    </tr>
  )
}
